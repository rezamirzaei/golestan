var milisec=0;var seconds=0;var milisect=60;var secondst=9;function display(){if(document.getElementById("time")){if(document.getElementById("time").value!="--:--"){if((milisect==1&&secondst==0)||secondst<0){document.getElementById("time").value="--:--";if(document.getElementById("SaleReferenceId").value==""){document.getElementById("ResCode").value="415"}document.forms.returnForm.submit()}else{if(milisec>=59){milisec=0;milisect=60;seconds+=1;secondst-=1}else{milisec+=1}}milisect-=1;if(document.getElementById("time").value!="--:--"){document.getElementById("time").value=secondst+":"+milisect;setTimeout("display()",1000)}}}}display();function getParam(b){b=b.replace(/[\[]/,"\\[").replace(/[\]]/,"\\]");var a="[\\?&]"+b+"=([^&#]*)";var d=new RegExp(a);var c=d.exec(window.location.href);if(c==null){return""}else{return c[1]}}function keyHandler(){switch(event.keyCode){case 13:doPay_value();break}}function check_KeyPress(e,c,a){var d=String.fromCharCode(event.keyCode);var b=false;for(i=0;i<a.length;i++){if(a.charAt(i)==d){b=true;break}}return b}function DoMask(a,h,c,g,f){DoNothing=0;KeyCode=event.keyCode;CurrentChar=String.fromCharCode(KeyCode);CurrentPos=c.value.length;var e=g.split(",");for(var d=0;d<=e.length;d++){for(var b=0;b<=h.length;b++){if(b==e[d]){if(h.substring(b,b+1)!=f){h=h.substring(0,b)+f+h.substring(b,h.length);c.value=h}}}}if(CurrentPos<a.length+e.length){if(a.charAt(CurrentPos)=="N"){if(!isNaN(CurrentChar)){DoNothing=0}else{DoNothing=1}}else{if(a.charAt(CurrentPos)=="/"){if(CurrentChar=="/"){DoNothing=0}else{DoNothing=1}}else{if(a.charAt(CurrentPos)=="L"){if(!isNaN(CurrentChar)){DoNothing=1}else{DoNothing=0}}}}}else{DoNothing=1}if(DoNothing==1){event.keyCode=0}return true}function canEN(){frmc.submit()}function doPay_value(){var a=true;if(document.getElementById("W_PAN1").value==""||(document.getElementById("W_PAN1").value.length)<4){document.getElementById("W_PAN1").style.background="#FEBFC0";a=false}else{document.getElementById("W_PAN1").style.background="#FEFEFE"}if(document.getElementById("W_PAN2").value==""||(document.getElementById("W_PAN2").value.length)<4){document.getElementById("W_PAN2").style.background="#FEBFC0";a=false}else{document.getElementById("W_PAN2").style.background="#FEFEFE"}if(document.getElementById("W_PAN3").value==""||(document.getElementById("W_PAN3").value.length)<4){document.getElementById("W_PAN3").style.background="#FEBFC0";a=false}else{document.getElementById("W_PAN3").style.background="#FEFEFE"}if(document.getElementById("W_PAN4").value==""||(document.getElementById("W_PAN4").value.length)<4||document.getElementById("W_PAN4").value<1000){document.getElementById("W_PAN4").style.background="#FEBFC0";a=false}else{document.getElementById("W_PAN4").style.background="#FEFEFE"}if(document.getElementById("W_PIN").value==""||(document.getElementById("W_PIN").value.length)<4){document.getElementById("W_PIN").style.background="#FEBFC0";a=false}else{document.getElementById("W_PIN").style.background="#FEFEFE"}if(document.getElementById("W_CVV2").value==""||(document.getElementById("W_CVV2").value.length)<3){document.getElementById("W_CVV2").style.background="#FEBFC0";a=false}else{document.getElementById("W_CVV2").style.background="#FEFEFE"}if(document.getElementById("W_CAPTCHA")){if(document.getElementById("W_CAPTCHA").value==""||(document.getElementById("W_CAPTCHA").value.length)<3){document.getElementById("W_CAPTCHA").style.background="#FEBFC0";a=false}else{document.getElementById("W_CAPTCHA").style.background="#FEFEFE"}}if(document.getElementById("W_EXPIRE1")){if(document.getElementById("W_EXPIRE1").value==""){document.getElementById("W_EXPIRE1").style.background="#FEBFC0";a=false}else{document.getElementById("W_EXPIRE1").style.background="#FEFEFE"}}if(document.getElementById("W_EXPIRE2")){if(document.getElementById("W_EXPIRE2").value==""){document.getElementById("W_EXPIRE2").style.background="#FEBFC0";a=false}else{document.getElementById("W_EXPIRE2").style.background="#FEFEFE"}}if(document.getElementById("W_EXPIRE1").value>12){document.getElementById("W_EXPIRE1").style.background="#FEBFC0";a=false}else{if(document.getElementById("W_EXPIRE1").value.length==1){document.getElementById("W_EXPIRE1").value="0"+document.getElementById("W_EXPIRE1").value}}if(document.getElementById("W_EXPIRE2").value.length==1){document.getElementById("W_EXPIRE2").value="0"+document.getElementById("W_EXPIRE2").value}if(document.getElementById("W_EMAIL").value!=null&&document.getElementById("W_EMAIL").value!=""){var c=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;var b=document.getElementById("W_EMAIL").value;if(c.test(b)==false){document.getElementById("W_EMAIL").style.background="#FEBFC0";a=false}else{document.getElementById("W_EMAIL").style.background="#FEFEFE"}}return a}function reset(){document.getElementById("W_PAN1").style.background="";document.getElementById("W_PAN2").style.background="";document.getElementById("W_PAN3").style.background="";document.getElementById("W_PAN4").style.background="";document.getElementById("W_PIN").style.background="";document.getElementById("W_CVV2").style.background="";document.getElementById("W_EMAIL").style.background=""}function nextTab(b,a){if(b.value.length>=b.maxLength||a){switch(b.tabIndex){case 1:document.getElementById("W_PAN3").focus();field=document.getElementById("W_PAN3");break;case 2:document.getElementById("W_PAN2").focus();field=document.getElementById("W_PAN2");break;case 3:document.getElementById("W_PAN1").focus();field=document.getElementById("W_PAN1");break;case 4:document.getElementById("W_PIN").focus();field=document.getElementById("W_PIN");break;case 5:document.getElementById("W_CVV2").focus();field=document.getElementById("W_CVV2");break;case 6:document.getElementById("W_EXPIRE1").focus();field=document.getElementById("W_EXPIRE1");break;case 7:document.getElementById("W_EXPIRE2").focus();field=document.getElementById("W_EXPIRE2");break;case 8:if(document.getElementById("W_CAPTCHA")){document.getElementById("W_CAPTCHA").focus();field=document.getElementById("W_CAPTCHA")}else{document.getElementById("doPay").focus();field=document.getElementById("doPay")}break;case 9:document.getElementById("doPay").focus();field=document.getElementById("doPay");break;default:document.getElementById("W_PAN4").focus();field=document.getElementById("W_PAN4");break}}}function nextTabs(c,b,a){if(a.keyCode==46||a.keyCode==16||a.keyCode==0||a.keyCode==13||a.keyCode==8||a.keyCode==9){}else{if(c.value.length>=c.maxLength||b){switch(c.tabIndex){case 1:document.getElementById("W_PAN3").focus();field=document.getElementById("W_PAN3");break;case 2:document.getElementById("W_PAN2").focus();field=document.getElementById("W_PAN2");break;case 3:document.getElementById("W_PAN1").focus();field=document.getElementById("W_PAN1");break;case 4:document.getElementById("W_PIN").focus();field=document.getElementById("W_PIN");break;case 5:document.getElementById("W_CVV2").focus();field=document.getElementById("W_CVV2");break;case 6:document.getElementById("W_EXPIRE1").focus();field=document.getElementById("W_EXPIRE1");break;case 7:document.getElementById("W_EXPIRE2").focus();field=document.getElementById("W_EXPIRE2");break;case 9:document.getElementById("W_EMAIL").focus();field=document.getElementById("W_EMAIL");break;case 8:if(document.getElementById("W_CAPTCHA")){document.getElementById("W_CAPTCHA").focus();field=document.getElementById("W_CAPTCHA")}else{document.getElementById("doPay").focus();field=document.getElementById("doPay")}break;case 9:document.getElementById("doPay").focus();field=document.getElementById("doPay");break}}}}function doNotPaste(){clipboardData.clearData()}var shuffleArray=new Array();var field="";shuffle=function(e){for(var c,a,b=e.length;b;c=parseInt(Math.random()*b),a=e[--b],e[b]=e[c],e[c]=a){}for(var d=0;d<10;d++){shuffleArray[d]=e[d]}return e};function c_random(){shuffleArray=shuffle([0,1,2,3,4,5,6,7,8,9]);for(var a=0;a<shuffleArray.length;a++){var b="btn"+a;document.getElementById(b).value="  "+shuffleArray[a]+"   "}}function getName(a){field=a}function fill(a){if(field==""||field==null){field=document.getElementById("W_PAN4")}if(field.type=="text"||field.type=="password"){value=a.value;if(field.value.length<field.maxLength){field.value+=trim(value)}nextTab(field,false);field.focus()}}function trim(a){a=this!=window?this:a;return a.replace(/^\s+/,"").replace(/\s+$/,"")}function backspace(){var a=field.value;if(field.type=="text"||field.type=="password"){field.value=a.substring(0,a.length-1)}}function tab(){nextTab(field,true)}function show(){var b=document.body.clientWidth-event.clientX;var a=document.body.clientHeight-event.clientY;if(b<document.getElementById("help").offsetWidth){document.getElementById("help").style.left=document.body.scrollLeft+event.clientX-document.getElementById("help").offsetWidth}else{document.getElementById("help").style.left=document.body.scrollLeft+event.clientX}if(a<document.getElementById("help").offsetHeight){document.getElementById("help").style.top=document.body.scrollTop+event.clientY-document.getElementById("help").offsetHeight}else{document.getElementById("help").style.top=document.body.scrollTop+event.clientY}document.getElementById("help").style.display="block"}function hide(){document.getElementById("help").style.display="none"}function getEventKeyCode(b){var a;if(window.event){a=event.keyCode}else{a=b.which}return a}function numericOnKeypress(b){var a=getEventKeyCode(b);if(ignoreKeys(a)){return true}if(isNumericKeysPressed(a)){return true}if(window.event){window.event.returnValue=false}else{b.preventDefault()}}function isNumericKeysPressed(a){if(a>=48&&a<=57){return true}return false}function ignoreKeys(a){if(a==0){return true}if(a==13){return true}if(a==16){return true}if(a==8){return true}if(a==9){return true}return false};