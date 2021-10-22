<%@page import="our.own.trip.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Our Own Trip(우리만의 여행)</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.png">

        <link rel="stylesheet" href="css/style.css">
        <%
		MemberDto mem = (MemberDto) session.getAttribute("login");
		System.out.println(mem);
		%>
		<style type="text/css">
		.submit-btn {
	font-size: 12px;
	font-weight: 700;
	background-color: white;
	color: #0f0101;
	line-height: 20px;
	width: 100%;
	border: none;
	padding: 5px;
	padding-left:"10px";
	margin-top: 10px;
	margin-bottom: 20px;
	
}
		</style>
    </head>
    <body>
<!-- PRELOADER -->
        <div id="preloader">
            <div class="preloader-area">
            	<div class="preloader-box">
            		<div class="preloader"></div>
            	</div>
            </div>
        </div>
							<%
							if (mem == null) {
							%>
        <header class="header-section">
            <nav class="navbar navbar-default">
                <div class="container" style="margin-right: 180px">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="main.do"><b>O</b>ur</a>
                         <a class="navbar-brand" href="main.do"><b>O</b>wn</a>
                          <a style="padding-right: 0px" class="navbar-brand" href="main.do"><b>T</b>rip</a>
                    </div>
                     <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav" style="margin-left: 0px">
                            <li class="active"><a href="main.do">Home</a></li>
                            <li><a href="share.do">여행 정보 공유</a></li>
							<li><a href="review.do">여행 후기 </a></li>
							<li><a href="pdslist.do">지역 홍보</a></li>
                        </ul>
                      	  
                        <ul class="nav navbar-nav navbar-right cart-menu">
                        <li><a href=""><i class="pe-7s-lock"></i></a></li>
                        <li><a href="login.do" style="padding-left: 5px">로그인</a></li>
                        <li><a href="" ><i class="pe-7s-add-user"></i></a></li>
                        <li><a href="regi.do" style="padding-left: 5px">회원가입</a></li>
                    </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </header>
		<%	
		}
		
		else {
		%>
		

		 <header class="header-section">
            <nav class="navbar navbar-default">
                <div class="container" style="margin-right: 180px">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="main.do"><b>O</b>ur</a>
                         <a class="navbar-brand" href="main.do"><b>O</b>wn</a>
                          <a class="navbar-brand" href="main.do"><b>T</b>rip</a>
                    </div>
                     <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="main.do">Home</a></li>
                            <li><a href="share.do">여행 정보 공유</a></li>
							<li><a href="review.do">여행 후기 </a></li>
							<li><a href="pdslist.do">지역 홍보</a></li>
                        </ul>


                      	  
                        <ul class="nav navbar-nav navbar-right cart-menu">
                        <li><a href="" style="padding-right: 5px" ><%=mem.getName()%>님</a></li>
						<li><a href=""><i class="pe-7s-unlock"></i></a></li>
                        <li><form action="logout.do" method="post">
                      
							<input type="hidden" name="mem" size="50px" value="<%=mem%>">
						
							<input type="submit" value="로그아웃" class="submit-btn">
						</form></li>
						<li><a href=""><i class="pe-7s-user"></i></a></li>
                        <li><a href="mypage.do?id=<%=mem.getId()%>" style="padding-left: 5px">my page</a></li>
						
                    </ul>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav><br><br>
            		<div>
					<p align="center">
						<span style="color: #1abc9c"><%=mem.getName()%></span>님 환영합니다. 여기는 Our Own Trip! 우리만의 여행 커뮤니티 입니다!</p>
						</div>
        </header>
        
		<%
		}
		%>
	</div>
	<br>

	
	<jsp:include page="mainpicture.jsp" flush="false" />

 <section class="news-section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="titie-section wow fadeInDown animated ">
                            <h1>Community</h1>
                        </div>
                    </div>
                </div>
                <div class="row" >
                    <div class="col-sm-4 wow fadeInDown animated" data-wow-delay="0.2s">
                        <div class="blog-item">
                            <a href="#"><img src="image/blog1.jpg" width="350" height="262" alt=""></a>
                            <h3>여행 정보를 공유하고 싶으신가요?</h3>
                            <p>자신만이 알고 있는 여행 정보를 공유해보세요! </p>
                            <a href="share.do" style="border-radius: 10px;">바로가기</a>
                        </div>
                    </div>
                    <div class="col-sm-4 wow fadeInDown animated" data-wow-delay="0.4s">
                        <div class="blog-item">
                            <a href="#"><img src="image/blog2.jpg" width="350" height="262" alt=""></a>
                            <h3>여행 후기를 남기고 싶으신가요?</h3>
                            <p>즐거웠던 여행을 기록해보세요!</p>
                            <a href="review.do" style="border-radius: 10px;">바로가기</a>

                        </div>
                    </div>
                    <div class="col-sm-4 wow fadeInDown animated" data-wow-delay="0.6s">
                        <div class="blog-item">
                            <a href="#"><img src="image/blog3.jpg" width="350" height="262" alt=""></a>
                            <h3>지역별 행사,할인 정보가 궁금하신가요? </h3>
                            <p>누구보다 빠르게 확인해보세요! </p>
                            <a href="pdslist.do" style="border-radius: 10px;">바로가기</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

 

        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p class="center">Copyright(c) 2021 <i class="fa fa-love"></i><a> OurOwnTrip &nbsp;</a>All rights reserved.
</p>
                        
                    </div>
                </div>
            </div>
        </footer>

        <!-- JQUERY -->
        <script src="js/vendor/jquery-1.11.2.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>