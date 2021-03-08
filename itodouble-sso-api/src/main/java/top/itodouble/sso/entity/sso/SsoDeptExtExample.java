package top.itodouble.sso.entity.sso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SsoDeptExtExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SsoDeptExtExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(Date value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(Date value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(Date value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(Date value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdIsNull() {
            addCriterion("dept_head_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdIsNotNull() {
            addCriterion("dept_head_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdEqualTo(String value) {
            addCriterion("dept_head_user_id =", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdNotEqualTo(String value) {
            addCriterion("dept_head_user_id <>", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdGreaterThan(String value) {
            addCriterion("dept_head_user_id >", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_head_user_id >=", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdLessThan(String value) {
            addCriterion("dept_head_user_id <", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdLessThanOrEqualTo(String value) {
            addCriterion("dept_head_user_id <=", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdLike(String value) {
            addCriterion("dept_head_user_id like", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdNotLike(String value) {
            addCriterion("dept_head_user_id not like", value, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdIn(List<String> values) {
            addCriterion("dept_head_user_id in", values, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdNotIn(List<String> values) {
            addCriterion("dept_head_user_id not in", values, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdBetween(String value1, String value2) {
            addCriterion("dept_head_user_id between", value1, value2, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadUserIdNotBetween(String value1, String value2) {
            addCriterion("dept_head_user_id not between", value1, value2, "deptHeadUserId");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameIsNull() {
            addCriterion("dept_head_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameIsNotNull() {
            addCriterion("dept_head_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameEqualTo(String value) {
            addCriterion("dept_head_name =", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameNotEqualTo(String value) {
            addCriterion("dept_head_name <>", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameGreaterThan(String value) {
            addCriterion("dept_head_name >", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_head_name >=", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameLessThan(String value) {
            addCriterion("dept_head_name <", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameLessThanOrEqualTo(String value) {
            addCriterion("dept_head_name <=", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameLike(String value) {
            addCriterion("dept_head_name like", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameNotLike(String value) {
            addCriterion("dept_head_name not like", value, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameIn(List<String> values) {
            addCriterion("dept_head_name in", values, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameNotIn(List<String> values) {
            addCriterion("dept_head_name not in", values, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameBetween(String value1, String value2) {
            addCriterion("dept_head_name between", value1, value2, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadNameNotBetween(String value1, String value2) {
            addCriterion("dept_head_name not between", value1, value2, "deptHeadName");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileIsNull() {
            addCriterion("dept_head_mobile is null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileIsNotNull() {
            addCriterion("dept_head_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileEqualTo(String value) {
            addCriterion("dept_head_mobile =", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileNotEqualTo(String value) {
            addCriterion("dept_head_mobile <>", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileGreaterThan(String value) {
            addCriterion("dept_head_mobile >", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileGreaterThanOrEqualTo(String value) {
            addCriterion("dept_head_mobile >=", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileLessThan(String value) {
            addCriterion("dept_head_mobile <", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileLessThanOrEqualTo(String value) {
            addCriterion("dept_head_mobile <=", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileLike(String value) {
            addCriterion("dept_head_mobile like", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileNotLike(String value) {
            addCriterion("dept_head_mobile not like", value, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileIn(List<String> values) {
            addCriterion("dept_head_mobile in", values, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileNotIn(List<String> values) {
            addCriterion("dept_head_mobile not in", values, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileBetween(String value1, String value2) {
            addCriterion("dept_head_mobile between", value1, value2, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andDeptHeadMobileNotBetween(String value1, String value2) {
            addCriterion("dept_head_mobile not between", value1, value2, "deptHeadMobile");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeIsNull() {
            addCriterion("social_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeIsNotNull() {
            addCriterion("social_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeEqualTo(String value) {
            addCriterion("social_credit_code =", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeNotEqualTo(String value) {
            addCriterion("social_credit_code <>", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeGreaterThan(String value) {
            addCriterion("social_credit_code >", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("social_credit_code >=", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeLessThan(String value) {
            addCriterion("social_credit_code <", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("social_credit_code <=", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeLike(String value) {
            addCriterion("social_credit_code like", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeNotLike(String value) {
            addCriterion("social_credit_code not like", value, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeIn(List<String> values) {
            addCriterion("social_credit_code in", values, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeNotIn(List<String> values) {
            addCriterion("social_credit_code not in", values, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeBetween(String value1, String value2) {
            addCriterion("social_credit_code between", value1, value2, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andSocialCreditCodeNotBetween(String value1, String value2) {
            addCriterion("social_credit_code not between", value1, value2, "socialCreditCode");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNull() {
            addCriterion("registered_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNotNull() {
            addCriterion("registered_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressEqualTo(String value) {
            addCriterion("registered_address =", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotEqualTo(String value) {
            addCriterion("registered_address <>", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThan(String value) {
            addCriterion("registered_address >", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("registered_address >=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThan(String value) {
            addCriterion("registered_address <", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThanOrEqualTo(String value) {
            addCriterion("registered_address <=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLike(String value) {
            addCriterion("registered_address like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotLike(String value) {
            addCriterion("registered_address not like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIn(List<String> values) {
            addCriterion("registered_address in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotIn(List<String> values) {
            addCriterion("registered_address not in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressBetween(String value1, String value2) {
            addCriterion("registered_address between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotBetween(String value1, String value2) {
            addCriterion("registered_address not between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameIsNull() {
            addCriterion("dept_opt_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameIsNotNull() {
            addCriterion("dept_opt_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameEqualTo(String value) {
            addCriterion("dept_opt_name =", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameNotEqualTo(String value) {
            addCriterion("dept_opt_name <>", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameGreaterThan(String value) {
            addCriterion("dept_opt_name >", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_opt_name >=", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameLessThan(String value) {
            addCriterion("dept_opt_name <", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_opt_name <=", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameLike(String value) {
            addCriterion("dept_opt_name like", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameNotLike(String value) {
            addCriterion("dept_opt_name not like", value, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameIn(List<String> values) {
            addCriterion("dept_opt_name in", values, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameNotIn(List<String> values) {
            addCriterion("dept_opt_name not in", values, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameBetween(String value1, String value2) {
            addCriterion("dept_opt_name between", value1, value2, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptNameNotBetween(String value1, String value2) {
            addCriterion("dept_opt_name not between", value1, value2, "deptOptName");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileIsNull() {
            addCriterion("dept_opt_mobile is null");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileIsNotNull() {
            addCriterion("dept_opt_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileEqualTo(String value) {
            addCriterion("dept_opt_mobile =", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileNotEqualTo(String value) {
            addCriterion("dept_opt_mobile <>", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileGreaterThan(String value) {
            addCriterion("dept_opt_mobile >", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileGreaterThanOrEqualTo(String value) {
            addCriterion("dept_opt_mobile >=", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileLessThan(String value) {
            addCriterion("dept_opt_mobile <", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileLessThanOrEqualTo(String value) {
            addCriterion("dept_opt_mobile <=", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileLike(String value) {
            addCriterion("dept_opt_mobile like", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileNotLike(String value) {
            addCriterion("dept_opt_mobile not like", value, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileIn(List<String> values) {
            addCriterion("dept_opt_mobile in", values, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileNotIn(List<String> values) {
            addCriterion("dept_opt_mobile not in", values, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileBetween(String value1, String value2) {
            addCriterion("dept_opt_mobile between", value1, value2, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andDeptOptMobileNotBetween(String value1, String value2) {
            addCriterion("dept_opt_mobile not between", value1, value2, "deptOptMobile");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceIsNull() {
            addCriterion("dept_address_province is null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceIsNotNull() {
            addCriterion("dept_address_province is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceEqualTo(String value) {
            addCriterion("dept_address_province =", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceNotEqualTo(String value) {
            addCriterion("dept_address_province <>", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceGreaterThan(String value) {
            addCriterion("dept_address_province >", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("dept_address_province >=", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceLessThan(String value) {
            addCriterion("dept_address_province <", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("dept_address_province <=", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceLike(String value) {
            addCriterion("dept_address_province like", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceNotLike(String value) {
            addCriterion("dept_address_province not like", value, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceIn(List<String> values) {
            addCriterion("dept_address_province in", values, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceNotIn(List<String> values) {
            addCriterion("dept_address_province not in", values, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceBetween(String value1, String value2) {
            addCriterion("dept_address_province between", value1, value2, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("dept_address_province not between", value1, value2, "deptAddressProvince");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityIsNull() {
            addCriterion("dept_address_city is null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityIsNotNull() {
            addCriterion("dept_address_city is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityEqualTo(String value) {
            addCriterion("dept_address_city =", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityNotEqualTo(String value) {
            addCriterion("dept_address_city <>", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityGreaterThan(String value) {
            addCriterion("dept_address_city >", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("dept_address_city >=", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityLessThan(String value) {
            addCriterion("dept_address_city <", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityLessThanOrEqualTo(String value) {
            addCriterion("dept_address_city <=", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityLike(String value) {
            addCriterion("dept_address_city like", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityNotLike(String value) {
            addCriterion("dept_address_city not like", value, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityIn(List<String> values) {
            addCriterion("dept_address_city in", values, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityNotIn(List<String> values) {
            addCriterion("dept_address_city not in", values, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityBetween(String value1, String value2) {
            addCriterion("dept_address_city between", value1, value2, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressCityNotBetween(String value1, String value2) {
            addCriterion("dept_address_city not between", value1, value2, "deptAddressCity");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaIsNull() {
            addCriterion("dept_address_area is null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaIsNotNull() {
            addCriterion("dept_address_area is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaEqualTo(String value) {
            addCriterion("dept_address_area =", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaNotEqualTo(String value) {
            addCriterion("dept_address_area <>", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaGreaterThan(String value) {
            addCriterion("dept_address_area >", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaGreaterThanOrEqualTo(String value) {
            addCriterion("dept_address_area >=", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaLessThan(String value) {
            addCriterion("dept_address_area <", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaLessThanOrEqualTo(String value) {
            addCriterion("dept_address_area <=", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaLike(String value) {
            addCriterion("dept_address_area like", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaNotLike(String value) {
            addCriterion("dept_address_area not like", value, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaIn(List<String> values) {
            addCriterion("dept_address_area in", values, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaNotIn(List<String> values) {
            addCriterion("dept_address_area not in", values, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaBetween(String value1, String value2) {
            addCriterion("dept_address_area between", value1, value2, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressAreaNotBetween(String value1, String value2) {
            addCriterion("dept_address_area not between", value1, value2, "deptAddressArea");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailIsNull() {
            addCriterion("dept_address_detail is null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailIsNotNull() {
            addCriterion("dept_address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailEqualTo(String value) {
            addCriterion("dept_address_detail =", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailNotEqualTo(String value) {
            addCriterion("dept_address_detail <>", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailGreaterThan(String value) {
            addCriterion("dept_address_detail >", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("dept_address_detail >=", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailLessThan(String value) {
            addCriterion("dept_address_detail <", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("dept_address_detail <=", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailLike(String value) {
            addCriterion("dept_address_detail like", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailNotLike(String value) {
            addCriterion("dept_address_detail not like", value, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailIn(List<String> values) {
            addCriterion("dept_address_detail in", values, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailNotIn(List<String> values) {
            addCriterion("dept_address_detail not in", values, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailBetween(String value1, String value2) {
            addCriterion("dept_address_detail between", value1, value2, "deptAddressDetail");
            return (Criteria) this;
        }

        public Criteria andDeptAddressDetailNotBetween(String value1, String value2) {
            addCriterion("dept_address_detail not between", value1, value2, "deptAddressDetail");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }


}