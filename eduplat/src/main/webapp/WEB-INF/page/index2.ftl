学秩首页。。。。。。。。。。。。。。。
<center>
    <h1>文件上传</h1>
    <form name="uploadform" method="post" action="teaching/teacher/uploadCwr" ENCTYPE="multipart/form-data"> 
        <table border="1"width="450"cellpadding="4" cellspacing="2"bordercolor="#9BD7FF">
            <tr>
            	<td width="100%" colspan="2">
               		 课件UUID：<input name="cwrId"size="40" type="text" value="402880e53d7dd702013d7dd70e680000">
            	</td>
            	<td width="100%" colspan="2">
               		 文件：<input name="file"size="40" type="file">
            	</td>
        	</tr>
        </table>
        <table>
            <tr><td align="center"><input name="upload" type="submit" value="上传"/></td></tr>
        </table>
    </form>
</center>
<a href="teaching/teacher/downloadCwr?cwrId=402880e53d7dd702013d7dd70e680000">下载课件</a><br />

<a href="teaching/teacher/index">教师首页</a><br/>
<a href="teaching/teacher/reviewAsm?asmId=ef0002b13dd43434013dd43483c20000">预览作业</a><br/>
<a href="teaching/student/index">学生首页</a><br/>
<a href="teaching/student/startAsm?asmId=ef0002b13dd43434013dd43483c20000">开始作答</a><br/>
<a href="teaching/student/readAss?asmId=ef0002b13dd43434013dd43483c20000">回顾卷子</a><br/>

<a href="login">登录</a><br/>
<a href="logout">退出</a><br/>