package com.ejet.comm.utils.thread;

import java.io.IOException;
import java.io.InputStream;

public class InterruptReaderThread extends Thread {

	private Object lock = new Object();
	private InputStream is;
	private boolean done = false;
	private final int buflen;
	private String error = null;
	StringBuffer outData = new StringBuffer();

	protected void processData(byte[] b, int n) {
		outData.append(new String(b), 0, n);
	}

	class ReaderClass extends Thread {

		public void run() {
			byte[] buffer = new byte[buflen];
			while (!done) {
				try {
					int read = 0;
					while ((read = is.read(buffer, 0, buflen)) > 0) {
						processData(buffer, read);
					}
					done = true;
				} catch (IOException ioe) {
					done = true;
					// error = DLog.getStackTraceString(ioe);
				}
			}
			synchronized (lock) {
				lock.notify();
			}
		}
	}

	public InterruptReaderThread(InputStream is) {
		this(is, 1024);
	}

	public InterruptReaderThread(InputStream is, int len) {
		this.is = is;
		buflen = len;
	}

	public void run() {
		ReaderClass rc = new ReaderClass();
		synchronized (lock) {
			rc.start();
			while (!done) {
				try {
					lock.wait();
				} catch (InterruptedException ie) {
					done = true;
					rc.interrupt();
					// error = DLog.getStackTraceString(ie);
					try {
						is.close();
					} catch (IOException ioe) {
						// error = DLog.getStackTraceString(ioe);
					}
				}
			} // while
		} // synchronized
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public StringBuffer getOutData() {
		if (outData == null || outData.length() == 0) {
			outData = null;
		}
		return outData;
	}

	public String getError() {
		return error;
	}

}
