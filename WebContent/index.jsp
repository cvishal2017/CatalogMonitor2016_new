<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title id="titleElement">IBM Bluemix - Next-Generation Cloud App Development Platform</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
    <style type="text/css">

      /* Sticky footer styles
      -------------------------------------------------- */

      html,
      body {
        height: 100%;
        /* The html and body elements cannot have any padding or margin. */
      }

      /* Wrapper for page content to push down footer */
      #wrap {
        min-height: 100%;
        height: auto !important;
        height: 100%;
		width: 100%;
        /* Negative indent footer by it's height */
        margin: 0px 0px -60px 0px;
      }

      /* Set the fixed height of the footer here */
      #push,
      #footer {
        height: 60px;
      }
      #footer {
        background-color: #f5f5f5;
      }



      /* Custom page CSS
      -------------------------------------------------- */
      /* Not required for template or sticky footer method. */

      #wrap > .container {
        padding-top: 60px;
      }

      code {
        font-size: 80%;
      }

    </style>
</head>

<body bgcolor="#FFF34" >
<div id="wrap">

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<table width="100%" height="40">
				<tr width="100%" height="40">
					<td width="100%" height="50" bgcolor="142633">
					<img src="images/bluemix.png" height="50" ></img>
					<font color="white"> - Monitoring Utility </font>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<br><br><br>
	<br>
	<div>
	<p>
		Welcome to Bluemix Monitor Utility. This utility has been designed to monitor changes happening in Bluemix Catalog, any announcements being done around Bluemix, top viewed Bluemix articles as well as Top Recent Question asked about Bluemix on StackOverflow.
		You can subscribe to this utility to receive daily updates or unsubscribe if you want to stop receiving updates.
	</p>
	</div>
	
	<div class="container">
		<form method="post" action="/monitorservlet">
		  <input type="button" class="btn btn-info" value="Subscribe">
		  <input type="button" class="btn btn-info" value="Unsubscribe">
	  	</form>
	</div>

</div>
<div id="footer">
	<table width="100%" height="40">
		<tr width="100%" valign="top">
		<tr width="100%" height="40">
			<td align="right" width="100%" height="50" bgcolor="142633">
			<font color="white">Powered by </font>
			<img src="images/bluemix.png" height="50" ></img>
			</td>
		</tr>
	</table>
</div>
</body>

</html>