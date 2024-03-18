<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Kode+Mono:wght@400..700&display=swap" rel="stylesheet">
        <link href="../../../CSS/toggle.css" rel="stylesheet" type="text/css">
        <title>LV-BANK</title>
    </head>
    <body id="body-main">
        <div id="nav-bar">
            <img id="logo" src="../../images/logo.png">
            <p>Lake View Bank</p>
            <div> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Card Master Registration </div>
        </div>
        <div id="body-box">
            <form class="formBody" name="signUpUserForm" method="post" action="AddCardMaster">
                    <div id ="div1">
                        <label class="divlDrp" htmlFor="b2" >Card Type</label>
                        <select class="inlDrp" id="b2" name="cardType" onchange="doIt(this);">
                            <option value="creditCard">Credit Card</option>
                            <option value="coBrandedCreditCard">Co Branded Credit Card</option>
                            <option value="debitCard">Debit Card</option>
                        </select>
                    </div>
                    <label htmlFor="b2">Card Name</label>
                    <input type="text" id="b2" name="cardName" required="required"/>
                    <label htmlFor="b3">Card Payment Gateway</label>
                    <input type="text" id="b3" name="cardPaymentGateway" required="required"/>

                        <label id ="debit" htmlFor="b4">Debit Card Withdrawal Limit</label>
                        <input type="text" id="b4" name="withdrawalLimit"/>

                        <label id ="credit" htmlFor="b4">Interest Free Credit Days</label>
                        <input type="text" id="b4" name="interestFreeCreditDays"/>
                        <label id ="credit" htmlFor="b5">Rate Of Interest</label>
                        <input type="text" id="b5" name="rateOfInterest"/>

                        <label id ="coCredit" htmlFor="b4">Interest Free Credit Days</label>
                        <input type="text" id="b4" name="interestFreeCreditDays"/>
                        <label id ="coCredit" htmlFor="b5">Rate Of Interest</label>
                        <input type="text" id="b5" name="rateOfInterest"/>
                        <label id ="coCredit" htmlFor="b6">Credit Card Merchant Name</label>
                        <input type="text" id="b6" name="merchantName"/>
                        <label id ="coCredit" htmlFor="b7">Credit Card Merchant Offer Percentage</label>
                        <input type="text" id="b7" name="merchantOfferPercentage"/>

                    <button type='submit' name='signUp' >SIGN UP</button>
                </form>
        </div>
    </body>
    <style type="text/css">

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
