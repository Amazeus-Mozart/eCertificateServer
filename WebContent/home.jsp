<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<head>
<title>JavaUsageSurvey</title>
</head>

<body bgcolor=#ffffff>
	<p>
		<img src=images/BEA_Button_Final_web.gif align=right>
	<blockquote>
		<font face="helvetica">
			<form action="SurveyServlet" method=POST>
				<input type=hidden name=survey value=Survey01Results> <BR>
				<BR>How Many Employees in your Company?<BR> <BR>1-100
				<input type=radio name=employee value=1-100> <BR>100-200
				<input type=radio name=employee value=100-200> <BR>200-300
				<input type=radio name=employee value=200-300> <BR>300-400
				<input type=radio name=employee value=300-400> <BR>500-more
				<input type=radio name=employee value=500-more> <BR> <BR>General
				Comments?<BR> <BR> <input type=text name=comment>
				<BR> <BR>What IDEs do you use?<BR> <BR>JavaWorkShop
				<input type=checkbox name=ide value=JavaWorkShop> <BR>J++
				<input type=checkbox name=ide value=J++> <BR>Cafe <input
					type=checkbox name=ide value=Cafe�> <BR> <BR> <input
					type=submit><input type=reset>
			</form>
		</font>
	</blockquote>
</body>
</html>