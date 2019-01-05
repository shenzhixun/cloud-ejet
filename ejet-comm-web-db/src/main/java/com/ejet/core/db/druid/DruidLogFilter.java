package com.ejet.core.db.druid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DruidLogFilter extends com.alibaba.druid.filter.logging.Slf4jLogFilter {

	private final Logger log = LoggerFactory.getLogger(DruidLogFilter.class);
	@Override
    protected void statementLog(String message) {
		super.statementLog(message);
		log.warn("新增加调试：" + message);
    }

    @Override
    protected void resultSetLog(String message) {
    	super.resultSetLog(message);
    	log.warn("新增加调2：" + message);
    }

}
