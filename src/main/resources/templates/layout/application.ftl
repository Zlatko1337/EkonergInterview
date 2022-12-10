<#import "/spring.ftl" as spring/>
<#macro layout>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Example</title>
    <link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
	<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/jquery.min.js"></script>
</head>

<body style="background-color:#212529;">
    <nav class="navbar navbar-default">
        <div class="container">
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <#--<li><a href="/jedan/">Jedan</a></li>
                    <li><a href="/dva/">Dva</a></li> -->
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <#nested>
    </div>
</body>
</html>
</#macro>