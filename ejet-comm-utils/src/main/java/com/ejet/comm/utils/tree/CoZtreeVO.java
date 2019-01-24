package com.ejet.comm.utils.tree;

/**
 *  树节点信息
 * @author ejet
 * 
 */
public class CoZtreeVO implements java.io.Serializable {
	private Integer id;
	private Integer pid;
	private Integer level;
	private Integer type;
	private String name;
	private String css;
	private String namEn;
	private String url;
	private Integer sort;
	
	private String ext;
	private String ext2;

	public CoZtreeVO(Integer sort,Integer id, Integer pid, Integer level, String name, Integer type, String css, String ext, String ext2,String namEn, String url) {
	    this.sort = sort;
		this.id = id;
		this.pid = pid;
		this.level = level;
		this.type = type;
		this.name = name;
		this.css = css;
		this.namEn = namEn;
		this.url = url;

		this.ext = ext;
		this.ext2 = ext2;
	}
	
	public CoZtreeVO(Integer sort,Integer id, Integer pid, Integer level, String name, Integer type, String css,String namEn, String url) {
		this(sort,id, pid, level, name, type, css, null, null, namEn,url);
	}
	
	public CoZtreeVO(Integer sort,Integer id, Integer pid, Integer level, String name, Integer type,String namEn ,String css) {
		this(sort,id, pid, level, name, type, css, null, null,namEn, null);
	}
	
	public String getNamEn() {
        return namEn;
    }

    public void setNamEn(String namEn) {
        this.namEn = namEn;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("id:").append(id).append(", ").append("pid:").append(pid)
				.append(", ").append("level:").append(level).append(", ")
				.append("name:").append(name).append(", ").append("url:")
				.append(url).append(", ")
		// .append("nodes:").append(nodes.toString())
		;
		return buff.toString();
	}

}
