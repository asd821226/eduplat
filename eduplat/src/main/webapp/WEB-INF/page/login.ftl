<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VCS 用户登录</title>

<!-- 用于布局的css -->
<link href="resources/styles/layout.css" rel="stylesheet" type="text/css" />
<!-- 图标的css -->
<link href="resources/styles/icon.css" rel="stylesheet" type="text/css" />
<!-- 控件布局的css -->
<link href="resources/styles/component.css" rel="stylesheet" type="text/css" />

<!-- jquery 核心代码 -->
<script type="text/javascript" src="resources/scripts/jquery.core.js"></script>

<script type="text/javascript">
	function login(){
		$("#login_form").submit();
	}
	function reloadValidateCode() {
		$("#validateCodeImg").attr("src","/eduplat/validateCode?date = " + new Date() + Math.floor(Math.random()*24));
	}
</script>

</head>

<body>

	<div id="login_container">
		<div class="logo"></div>
    	<div class="panel_title">
        	<span class="login24_icon">用户登录</span>
		</div>
        <div class="panel_content">
        	<#if shiroLoginFailure?has_content>
        		<center><font color="#FF0000">${shiroLoginFailure}</font></center>
        	</#if>
        	<form id="login_form" method="post" action="login">
            	<div class="column">
                	<label for="username">
                    	用户名:
                    </label>
                    <div class="field">
                    	<input type="text" name="username" id="username" class="text_input_big" size="25" value="admin"/>
                    </div>
                </div>
                <div class="column">
                	<label for="password">
                    	密  码:
                    </label>
                    <div class="field">
                    	<input type="password" name="password" id="password" class="text_input_big" size="25" value="admin"/>
                	</div>
                </div>
                <div class="column">
                	<label for="validateCode">
                    	验证码:
                    </label>
                    <div class="field">
                    	<input type="text" name="validateCode" id="validateCode" class="text_input_big" size="8" />
                    	<img id="validateCodeImg" src="/eduplat/validateCode" width="70" height="28"  align="absmiddle"/>
                    	<a href="javascript:reloadValidateCode();">看不请?</a>
                	</div>
                </div>
            </form>
        </div>
		<div class="panel_footer">
        	<a href="javascript:login();"><span class="button">登 录</span></a>
        </div>
    </div>
</body>