<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>

<c:url var="loginEmp" value="/Login/loginEmp.html"/>
<c:url var="logout" value="/Login/loginEmp.html"/>
<c:url var="loginMrg" value="/Login/loginMngr.html"/>
<div style="margin-bottom:8px;margin-top:100px;text-align:center"><a href="${loginEmp}"><img src="https://scontent-a-sea.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/1978781_406613382836059_5709801125763472163_n.jpg?oh=b2353f4e3c0e51b8a70781cc59c5aa82&oe=5515633A"/></a></div><br>
<div style="margin-bottom:8px;text-align:center"><a href="${loginMrg}"><img src="https://fbcdn-sphotos-e-a.akamaihd.net/hphotos-ak-xfp1/v/t1.0-9/10402702_406613389502725_2895573127323229717_n.jpg?oh=74082d7ade2e2fe073f133f2041ab628&oe=550264F9&__gda__=1426096752_4c0d28c4e8b20f6394b6db7f18bbd371"/></a></div><br>
<div style="margin-bottom:8px;text-align:center"><a href="${loginEmp}"><img src="https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-xpa1/v/t1.0-9/10850115_406613386169392_9156407097004720517_n.jpg?oh=bc0b3e22d1f5865207461af1741e04be&oe=5510FA57&__gda__=1426474479_4c06625aece03744c865b53df5106a65"/></a></div>
<a href="${logout}">logout</a>
<div style="position:absolute;margin-left:1200px;margin-top:120px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>
</body>
</html>
