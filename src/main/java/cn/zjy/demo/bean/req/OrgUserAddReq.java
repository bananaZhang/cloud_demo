package cn.zjy.demo.bean.req;

import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZJY
 * @ClassName: OrgUserAddReq
 * @Description: OrgUserAddReq
 * @date 2018/10/29 19:24
 */
@Builder
public class OrgUserAddReq implements Serializable {

	private static final long serialVersionUID = -7986693769744153793L;

	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 其他联系方式
	 */
	private String otherContact;
	/**
	 * 职称
	 */
	private String title;
	/**
	 * 任职机构
	 */
	private String organization;
	/**
	 * 任职科室
	 */
	private String department;
	/**
	 * 添加价格的列表
	 */
	private List<OrgPriceAddReq> priceAddReqList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtherContact() {
		return otherContact;
	}

	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<OrgPriceAddReq> getPriceAddReqList() {
		return priceAddReqList;
	}

	public void setPriceAddReqList(List<OrgPriceAddReq> priceAddReqList) {
		this.priceAddReqList = priceAddReqList;
	}

	@Override
	public String toString() {
		return "OrgUserAddReq{" +
				"name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", otherContact='" + otherContact + '\'' +
				", title='" + title + '\'' +
				", organization='" + organization + '\'' +
				", department='" + department + '\'' +
				'}';
	}

	static class OrgPriceAddReq {
		private String modality;

		private Integer price;

		public String getModality() {
			return modality;
		}

		public void setModality(String modality) {
			this.modality = modality;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}
	}
}
