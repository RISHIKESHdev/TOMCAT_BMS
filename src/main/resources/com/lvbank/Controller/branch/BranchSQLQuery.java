package com.lvbank.Controller.branch;

public class BranchSQLQuery {
    public static final String GET_ACTIVE_BRANCH_ID="select branch_id from branch where is_Active=TRUE";
    static final String INSERT_BRANCH_QUERY="INSERT INTO Branch(branch_Name,mobile_Number,bank_Id,address_Id,geoLocation_Id) VALUE(?,?,?,?,?)";
    static final String UPDATE_BRANCH_IFSC_QUERY="UPDATE Branch SET IFSC_Code=? WHERE branch_Id=?";
}
