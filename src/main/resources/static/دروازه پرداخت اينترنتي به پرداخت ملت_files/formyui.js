$(document).ready(function(){var a=false;$(function(){$(document).ajaxSend(function(){document.getElementById("AjaxLoad").src="images/load.gif";document.getElementById("AjaxLoad").width=16;document.getElementById("AjaxLoad").height=16;$("#alert").attr("class","Info");$("#alert").text("درحال ارسال اطلاعات ...")});$(document).ajaxStop(function(){document.getElementById("AjaxLoad").src="images/unload.gif";document.getElementById("AjaxLoad").width=1;document.getElementById("AjaxLoad").height=1;if(!a){if(document.getElementById("doPay")){document.getElementById("doPay").disabled=false}if(document.getElementById("doCancel")){document.getElementById("doCancel").disabled=false}$("#alert").attr("class","Error");$("#alert").text("خطا سيستمي ")}a=false})});$("form").submit(function(){return false});$("#change").click(function(){document.getElementById("security").src="captchaimg.jpg?RefId="+document.getElementById("RefId").value+"&rnd= "+Math.random()});$("#doPay").click(function(){if(doPay_value()){$("#doPay").attr("disabled","true");$("#doCancel").attr("disabled","true");$W_REFID=document.getElementById("RefId").value;if(document.getElementById("W_CAPTCHA")){$W_CAPTCHA=document.getElementById("W_CAPTCHA").value}else{$W_CAPTCHA=""}$W_PAN4=document.getElementById("W_PAN4").value;$W_PAN3=document.getElementById("W_PAN3").value;$W_PAN2=document.getElementById("W_PAN2").value;$W_PAN1=document.getElementById("W_PAN1").value;$W_PIN=document.getElementById("W_PIN").value;$W_CVV2=document.getElementById("W_CVV2").value;$W_EMAIL=document.getElementById("W_EMAIL").value;if(document.getElementById("W_PAYERID")){$W_PAYERID=document.getElementById("W_PAYERID").value}else{$W_PAYERID=""}$W_EXPIRE1=document.getElementById("W_EXPIRE1").value;$W_EXPIRE2=document.getElementById("W_EXPIRE2").value;$.post("PaymentServlet",{W_REFID:$W_REFID,W_CAPTCHA:$W_CAPTCHA,W_PAN4:$W_PAN4,W_PAN3:$W_PAN3,W_PAN2:$W_PAN2,W_PAN1:$W_PAN1,W_PIN:$W_PIN,W_CVV2:$W_CVV2,W_PAYERID:$W_PAYERID,W_EXPIRE1:$W_EXPIRE1,W_EXPIRE2:$W_EXPIRE2,W_EMAIL:$W_EMAIL},function(b){a=true;if($("captchaStatus",b).text()=="true"){if($("payerIdStatus",b).text()=="true"){if($("statusCode",b).text()!="0"){if($("statusCode",b).text()=="419"||$("statusCode",b).text()=="415"){document.getElementById("time").value="--:--";$("#alert").attr("class","Error");$("#alert").text($("statusDescription",b).text());document.getElementById("ResCode").value=$("statusCode",b).text();document.getElementById("SaleReferenceId").value="";document.forms.returnForm.submit();return true}else{document.getElementById("security").src="captchaimg.jpg?RefId="+document.getElementById("RefId").value+"&rnd= "+Math.random();$("#alert").attr("class","Error");$("#alert").text($("statusDescription",b).text());document.getElementById("doPay").disabled=false;document.getElementById("doCancel").disabled=false;document.getElementById("W_PIN").value="";document.getElementById("W_CVV2").value="";document.getElementById("W_CAPTCHA").value="";return false}}else{document.getElementById("ResCode").value=$("statusCode",b).text();document.getElementById("SaleReferenceId").value=$("saleReferenceId",b).text();document.getElementById("CardHolderInfo").value=$("cardHolderInfo",b).text();document.getElementById("pan").value=$("pan",b).text();if($("giftAmount",b).text()>0){document.getElementById("GiftAmount").value=$("giftAmount",b).text();$("#alert").attr("class","Info");$("#alert").text("پرداخت با موفقيت انجام شد. ...")}$("#alert").attr("class","Info");$("#alert").text("پرداخت با موفقيت انجام شد. ...");document.forms.receiptForm.submit();return true}}else{document.getElementById("W_PAYERID").style.background="#FEBFC0";$("#alert").attr("class","Error");$("#alert").text("لطفا ورودی های خود را کنترل نمایید");document.getElementById("doPay").disabled=false;document.getElementById("doCancel").disabled=false;return false}}else{document.getElementById("W_CAPTCHA").style.background="#FEBFC0";$("#alert").attr("class","Error");$("#alert").text("لطفا ورودی های خود را کنترل نمایید");document.getElementById("doPay").disabled=false;document.getElementById("doCancel").disabled=false;return false}})}else{$("#alert").attr("class","Error");$("#alert").text("لطفا ورودی های خود را کنترل نمایید");document.getElementById("doPay").disabled=false;document.getElementById("doCancel").disabled=false;return false}});$("#doCancel").click(function(){document.getElementById("ResCode").value="17";document.getElementById("SaleReferenceId").value="";document.forms.returnForm.submit();return false})});