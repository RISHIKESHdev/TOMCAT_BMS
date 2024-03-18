package com.lvbank.Controller.profile.entry;

public class EntrySQLQuery {
    static final String SELECT_CUSTOMER_ON_LOGIN="SELECT first_Name,middle_Name,last_Name,email_Id,gender,password,age,mobile_Number,address_Line_One,address_Line_Two,address_Line_Three,landmark,city,state,country,pinCode,CIF_Number,CKYC_Verification_Document,CKYC_Verification_Id,PAN_Number FROM Address JOIN User JOIN Customer ON User.address_Id=Address.Address_Id AND User.Id=Customer.user_Id WHERE User.email_Id=? AND User.password=?";
    static final String SELECT_CUSTOMER_ACCOUNTS_QUERY="SELECT account_Number FROM Customer_Account_Map WHERE CIFNumber=?";
    static final String SELECT_EMPLOYEE_ON_LOGIN="SELECT Employee_Id,first_Name,middle_Name,last_Name,email_Id,gender,password,age,mobile_Number,address_Line_One,address_Line_Two,address_Line_Three,landmark,city,state,country,pinCode,Employee_Id,employee_Designation,employee_CTC,year_Of_Experience,is_Active FROM Address JOIN User JOIN Employee ON User.address_Id=Address.Address_Id AND User.Id=Employee.user_Id WHERE Employee.is_Active=True and User.email_Id=? AND User.password=?";
    static final String SELECT_ADMIN_ON_LOGIN="SELECT first_Name,middle_Name,last_Name,email_Id,gender,password,age,mobile_Number,address_Line_One,address_Line_Two,address_Line_Three,landmark,city,state,country,pinCode,is_Active FROM Address JOIN User JOIN Admin ON User.address_Id=Address.Address_Id AND User.Id=Admin.user_Id WHERE Admin.is_Active=True and User.email_Id=? AND User.password=?";
    static final String INSERT_USER_QUERY="INSERT INTO User(first_Name,middle_Name,last_Name,address_Id,email_Id,gender,password,age,mobile_Number) Value(?,?,?,?,?,?,?,?,?)";
    static final String INSERT_CUSTOMER_QUERY ="INSERT INTO Customer(user_Id,CKYC_Verification_Document,CKYC_Verification_Id,PAN_Number) Value(?,?,?,?)";
    static final String INSERT_EMPLOYEE_QUERY ="INSERT INTO Employee(user_Id,employee_Designation,employee_CTC,year_Of_Experience,is_Active) Value(?,?,?,?,?)";
    static final String INSERT_ADMIN_QUERY="INSERT INTO Admin(user_Id,is_Active) Value(?,?)";
    static final String INSERT_EMPLOYEE_BRANCH_MAP="INSERT INTO Employee_Branch_Map(employee_Id,branch_Id) VALUE(?,?)";
}
