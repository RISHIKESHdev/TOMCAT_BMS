<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Kode+Mono:wght@400..700&display=swap" rel="stylesheet">
        <link href="../../../CSS/toggle.css" rel="stylesheet" type="text/css">
        <title>LV-BANK</title>

        <script type="text/javascript"
                        src="jquery-ui-1.10.0/tests/jquery-1.9.0.js"></script>
                    <script src="jquery-ui-1.10.0/ui/jquery-ui.js"></script>
                    <script>
                    function populate(drpType){
                        var a = drpType.selectedIndex;
                        if(a==0){
                        document.getElementById("div2").style.display='block';
                        document.getElementById("div3").style.display='none';
                        document.getElementById("div4").style.display='none';
                        }else if(a==1){
                        document.getElementById("div2").style.display='none';
                        document.getElementById("div3").style.display='none';
                        document.getElementById("div4").style.display='block';
                        }else{
                        document.getElementById("div2").style.display='none';
                        document.getElementById("div3").style.display='block';
                        document.getElementById("div4").style.display='none';}
                    }
                    </script>
    </head>
    <body id="body-main">
        <div id="nav-bar">
            <img id="logo" src="../images/logo.png">
            <p>Lake View Bank</p>
            <div> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Card Registration </div>
        </div>
        <div id="body-box">
            <form class="formBody" name="registerCardForm" method="post" action="registerNewCard">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <div id ="div1">
                        <label class="divlDrp" htmlFor="b18" >Account Number</label>
                                                    <select class="inlDrp" id="b18" name="accountNumber">
                                                        <c:forEach items="${customerAccountNumbers}" var="accountNumber">
                                                            <option value="${accountNumber}">${accountNumber}</option>
                                                        </c:forEach>
                                                    </select>
                    </div>
                <div id ="div1">
                    <label class="divlDrp" htmlFor="b1" >Card-Type</label>
                    <select class="inlDrp" id="b1" name="cardType" onchange="populate(this);">
                        <option value="creditCard">Credit Card</option>
                        <option value="debitCard">Debit Card</option>
                        <option value="coBrandedCreditCard">Co Branded Credit Card</option>
                    </select>
                </div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <div id ="div2">
                    <label class="divlDrp" htmlFor="b2" >Master Id</label>
                    <select class="inlDrp" id="b2" name="creditMasterId">
                        <c:forEach items="${creditCardMasterIds}" var="creditMasterId">
                            <option value="${creditMasterId}">${creditMasterId}</option>
                        </c:forEach>
                    </select>
                </div>


                <div id ="div3">
                    <label class="divlDrp" htmlFor="b3" >Master Id</label>
                    <select class="inlDrp" id="b3" name="coCreditMasterId">
                        <c:forEach items="${coBrandCreditCardMasterIds}" var="coCreditMasterId">
                            <option value="${coCreditMasterId}">${coCreditMasterId}</option>
                        </c:forEach>
                    </select>
                </div>


                <div id ="div4">
                    <label class="divlDrp" htmlFor="b4" >Master Id</label>
                    <select class="inlDrp" id="b4" name="debitMasterId">
                        <c:forEach items="${debitCardMasterIds}" var="debitMasterId">
                            <option value="${debitMasterId}">${debitMasterId}</option>
                        </c:forEach>
                    </select>
                </div>


                    <button type='submit' name='signUp' >SIGN UP</button>
                </form>
        </div>
    </body>
    <style type="text/css">
            #div3 {
            display:none;
            }
            #div4 {
            display:none;
            }
            #logo{
                padding:5px;
                width:5%;
                height:80%;
            }
            #body-main{
                font-family: "Kode Mono", monospace;
                font-optical-sizing: auto;
                font-style: normal;

                margin-left:5%;
                display:flex;
                background: #ecf0f3;
                justify-content: center;
                align-items: center;
                flex-direction:column;
                height:100%;
                width:90%;
            }
            #nav-bar{
                display:flex;
                align-items: center;
                width:100%;
                height:10%;
                background: #ecf0f3;
                border-radius: 20px;
                margin: 20px;
                box-shadow: -6px -6px 6px rgba(255, 255, 255, 0.8),6px 6px 6px rgba(0, 0, 0, 0.2);
            }
            #body-box{
                display:flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width:100%;
                height:90%;
                background: #ecf0f3;
                border-radius: 20px;
                box-shadow: -6px -6px 6px rgba(255, 255, 255, 0.8),6px 6px 6px rgba(0, 0, 0, 0.2);
                margin-bottom:2%;
            }
            .formDiv {
                            width: 70%;
                            height: 85%;
                            padding: 20px 35px 15px 35px;
                            border-radius: 35px;
                            background: #ecf0f3;
                            box-shadow:
                            -6px -6px 6px rgba(255, 255, 255, 0.8),
                            6px 6px 6px rgba(0, 0, 0, 0.2);
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            justify-content: space-evenly;
                            margin-bottom: 2%;
                        }
                        .formBody{
                            width: 100%;
                            height: 100%;
                            border-radius: 35px;
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            justify-content: space-evenly;
                        }
                        label{
                            width:80%;
                            height:3%;
                        }
                        input{
                            border: none;
                            border-radius: 15px;
                            width:80%;
                            height:5.5%;
                            outline: none;
                            text-align: left;
                            text-indent: 10px;
                            box-shadow: inset 5px 5px 5px #cbced1,
                            inset -5px -5px 5px #ffffff;
                          }
                        #div1{
                            display:flex;
                            justify-content: space-around;
                            align-items: center;
                            height:5.5%;
                            width:80%;
                        }
                        #div2{
                            display:flex;
                            justify-content: space-around;
                            align-items: center;
                            height:5.5%;
                            width:80%;
                        }
                        #div3{
                            display:flex;
                            justify-content: space-around;
                            align-items: center;
                            height:5.5%;
                            width:80%;
                        }
                        #div4{
                            display:flex;
                            justify-content: space-around;
                            align-items: center;
                            height:5.5%;
                            width:80%;
                        }
                        .inl{
                            border: none;
                            border-radius: 15px;
                            width:40%;
                            height:100%;
                            outline: none;
                            text-align: left;
                            text-indent: 10px;
                            box-shadow: inset 5px 5px 5px #cbced1,
                            inset -5px -5px 5px #ffffff;
                        }
                        .divldrp{
                                                    width:50%;
                                                    padding-left:2%;
                                                    padding-bottom:1.7%;
                                                }
                        .inldrp{
                                                    border: none;
                                                    border-radius: 15px;
                                                    width:50%;
                                                    outline: none;
                                                    text-align: left;
                                                    text-indent: 10px;
                                                    box-shadow: inset 5px 5px 5px #cbced1,
                                                    inset -5px -5px 5px #ffffff;
                                                }
                        .divl{
                            width:20%;
                            padding-left:2%;
                            padding-bottom:1.7%;
                        }
                        button{
                            border: none;
                            border-radius: 35px;
                            width:30%;
                            height:6%;
                            box-shadow:
                            -6px -6px 6px rgba(255, 255, 255, 0.8),
                            6px 6px 6px rgba(0, 0, 0, 0.2);
                        }
                        button:hover{
                            cursor: pointer;
                            box-shadow:
                            -3px -3px 3px rgba(255, 255, 255, 0.8),
                            3px 3px 3px rgba(0, 0, 0, 0.2);
                            transition: 1s;
                        }
        </style>
</html>
