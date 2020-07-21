<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description"
	content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<style>
a { /*하이퍼링크 표시 없애기  */
	text-decoration: none;
}

ul {
	list-style: none; /*점 없애기  */
	overflow: auto;
}

.event .section_event_tab {
	position: relative;
}

.event_tab_lst.tab_lst_min {
	overflow: auto;
	background-color: white;
}

.category { /*전체리스트/전시  */
	float: left;
	text-align: center;
	width: 100px;
	height: 30px;
	padding: 3px;
	font-weight: bold;
	font-size: 20px;
	cursor : pointer;
}

a {
	text-decoration: none;
}

#container {
	width: 743px;
	background-color: #3e423a21;
	margin-left: 20%;
	margin-right: 20%;
}

.img_thumb { /*item안의 이미지  */
	width: 350px;
	height: 300px;
}

.item {/*각 행사정보  */
	width: 350px;
	height: 440px;
	background-color: #FFFFFB;
	margin: 5px;
	float: left;
	
}

hr { /*선 표시  */
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
}

.event_txt_tit { /*item 안의 공연 제목과 장소  */
	width: 330px;
	padding: 0 10px;
	overflow: hidden; /*정해진 공간을 넘어가면 감추기  */
	text-overflow: ellipsis; /*일정 글자수 넘으면 ...으로 표시*/
	white-space: nowrap;
	/*white-space는 스페이스와 탭, 줄바꿈, 자동줄바꿈을 어떻게 처리할지 정하는 속성  */
}

.event_txt_dsc { /*item 공연설명  */
	width: 330px;
	padding: 0 10px;
	margin-top: 1px;
	margin-bottom: 1px;
	overflow: hidden;
	text-overflow: ellipsis; /*일정 글자수 넘으면 ...으로 표시*/
	word-wrap: break-word;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2; /*라인수*/
	line-height: 1.2em;
	height: 2.4em;
}

.wrap_event_box { /*item묶은 박스  */
	padding: 2px 2px;
	background-color: #3e423a21;
}

.wrap_event_box>ul { /*1st_event_box  */
	overflow: auto;
	padding: 0px;
}

.event_lst_txt { /*바로 예매가능한 행사  */
	background-color: white;
	text-align: center;
	padding: 10px 0px;
}

.top{
	text-align: center;
	color: black;
}

.container_visual{ /*promotion div  */
	width: 600px;
	overflow : hidden;
	position : relative;
	left: 10%;
}

.promotion{ /*promotion item  */
	float:left;
}

.visual_img{/*promotion ul  */
	margin : 0;
	padding : 0;
}

.pink{/*빨간글씨  */
	color: red;
}

.btn_my{/*예약확인  */
	float: right;
    margin-right: 39px;
    margin-top: 20px;
}

</style>
</head>
<body>
	<div id="container">
		<div class="header">
			<!-- header -->
			<header class="header_tit">
				<span class="logo"> <!--네이버 로고  --> <a
					href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span
						class="spr_bi ico_n_logo"> <img
							src="img_icon\spr_bi ico_n_logo.png" width="50" height="50"
							alt="네이버"></img>
					</span>
				</a> <!--예약 로고  --> <a href="./myreservation.html" class="lnk_logo"
					title="예약"> <span class="spr_bi ico_bk_logo"> <img
							src="img_icon\spr_bi ico_bk_logo.png" width="110" height="50"
							alt="예약"></img>
					</span>
				</a>
				</span>

				<!--예약확인  -->
				<a href="./bookinglogin.html" class="btn_my" title="예약확인">예약확인</a>
			</header>
		</div>
		<hr>
		<div class="event">

			<!-- 슬라이딩 기능-->
			<div class="container_visual">
				<ul class="visual_img">
					<!--프로모션 이미지(무한슬라이드) -->
					<c:forEach items="${imgList }" var="img">
						<li class="promotion"><img src="${img.getUrl() }" width="600" height="300"></img></li>
					</c:forEach>

				</ul>
			</div>

			<!--event tab  -->
			<div class="section_event_tab">
				<!--전체리스트/전시/뮤지컬  -->
				<ul class="event_tab_lst tab_lst_min">
					<li class="category"><a class="anchor active">
						<span id="category0">전체리스트</span></a></li>
					<li class="category"><a class="anchor">
						<span id="category1">전시</span>
					</a></li>
					<li class="category"><a class="anchor">
						<span id="category2">뮤지컬</span>
					</a></li>
					<li class="category"><a class="anchor">
						<span id="category3">콘서트</span>
					</a></li>
					<li class="category"><a class="anchor">
						<span id="category4">클래식</span>
					</a></li>
					<li class="category"><a class="anchor">
						<span id="category5">연극</span>
					</a></li>

				</ul>
				<div class="section_event_lst">
					<p class="event_lst_txt">
						바로 예매 가능한 행사가 <span class="pink">10개</span> 있습니다
					</p>
				</div>

				<div class="wrap_event_box">
					
					<ul class="1st_event_box"></ul>
					
					<div class="more" style="text-align:center;">
						<!-- <button id="btn" name=""><span>더보기</span></button> -->
					</div>
				</div>
			</div>

		</div>


	</div>

	<div class="top">
		<a href="#">↑TOP</a>
	</div>

	
</body>

<!--item 템플릿  -->
<script id="event_template" type="text/template">
<li class="item">
    <a href="detail.html" class="item_book">
    <div class="item_preview"> 
		<img alt={alt} class="img_thumb" src="{src}"><span class="img_border"></span>
	</div>
    <div class="event_txt">
		<h4 class="event_txt_tit"> 
		<span>{title}</span><br>
		<small class="sm">{place}</small></h4>
		<hr>
        <p class="event_txt_dsc">{description}</p>
     </div>
      </a>
</li>

 </script>

<script>
	//처음 호출했을때 실행하는 html 템플릿
	var item_template = document.querySelector("#event_template").innerHTML;
	var resultHTML = "";
	var data = ${frontList};

	for (var i = 0; i < data.length; i++) {
		resultHTML += item_template.replace("{src}", data[i].save_file_name)
				.replace("{alt}", data[i].description).replace("{title}",
						data[i].description).replace("{place}",
						data[i].place_name).replace("{description}",
						data[i].content)
	}



	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"0\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
	
	//console.log(resultHTML);
	
	

    //category0(전체리스트)클릭했을때
    var category0 = document.getElementById("category0");
    category0.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${frontList};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
    									.replace("{alt}", data[i].description)
    									.replace("{title}", data[i].description)
    									.replace("{place}",	data[i].place_name)
    									.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"0\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    })
    
    //category1(전시)클릭했을때
    var category1 = document.getElementById("category1");
    category1.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${category1};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
    									.replace("{alt}", data[i].description)
    									.replace("{title}", data[i].description)
    									.replace("{place}",	data[i].place_name)
    									.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"1\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    })
    
      //category2(뮤지컬)클릭했을때
    	var category2 = document.getElementById("category2");
    	category2.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${category2};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
										.replace("{alt}", data[i].description)
										.replace("{title}", data[i].description)
										.replace("{place}",	data[i].place_name)
										.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"2\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    	})
    
        //category3(콘서트)클릭했을때
    	var category3 = document.getElementById("category3");
    	category3.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${category3};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
										.replace("{alt}", data[i].description)
										.replace("{title}", data[i].description)
										.replace("{place}",	data[i].place_name)
										.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"3\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    	})
    
        //category4(클래식)클릭했을때
   		 var category4 = document.getElementById("category4");
    	category4.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${category4};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
										.replace("{alt}", data[i].description)
										.replace("{title}", data[i].description)
										.replace("{place}",	data[i].place_name)
										.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"4\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    	})
    
        //category5(연극)클릭했을때
   		 var category5 = document.getElementById("category5");
    	category5.addEventListener("click", function(e){
    	
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";
    	var data = ${category5};

    	for (var i = 0; i < data.length; i++) {
    		resultHTML += item_template.replace("{src}", data[i].save_file_name)
										.replace("{alt}", data[i].description)
										.replace("{title}", data[i].description)
										.replace("{place}",	data[i].place_name)
										.replace("{description}",data[i].content)
    	}
    	document.querySelector(".wrap_event_box").firstElementChild.innerHTML = resultHTML;
    	document.querySelector(".more").innerHTML="<button id=\"btn\" name=\"5\" style=\"margin-bottom: 10px;\"><span>더보기</span></button>";
    	//더보기 클릭했을때 ajax호출
  		 var btn = document.getElementById("btn");
  		 btn.addEventListener("click",function(e) {

         var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
         //console.log(start);
         ajaxMoreContent(start);
       });
    	})
    
 	
	//더보기 기능 구현(ajax)
	function ajaxMoreContent(start){

           var oReq = new XMLHttpRequest();

           oReq.addEventListener("load", function() {
               //추가구문 출력 
        	   //console.log(this.responseText);
				var str = new Array();
				str = this.responseText.split("totalCount");
			 	var totalCount = Number(str[0]); //string으로 받는 숫자를 number로 형변환
				var data = str[1];
				
				//console.log(totalCount);
				//console.log(data);
				
				//console.log(typeof totalCount);
				 
				
				getMoreList(data);//추가할 정보 얻어오는 메소드 호출
				//item 개수 가져오기
				var item_num = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
				
				if(item_num == totalCount){ //모든 정보를 불러왔으면 더보기버튼 삭제
					document.getElementById("btn").remove();
				} 
            });
			
          	 var btn = document.getElementById("btn");
           	if(Number(btn.name) == 0){
           	  oReq.open("POST", "/reservation/getMoreContents", true);
              oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
              oReq.send(start); //ajax로 시작점(start) 보내기
           	} else{
           		oReq.open("POST", "/reservation/getMoreContents2", true);
                oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                oReq.send(start+" "+Number(btn.name)); //ajax로 시작점(start) + 카테고리 번호 보내기
           	}
          	 
          	 
           
    }
	

    	//더보기 클릭한후 템플릿이용해서 정보 추가하는 메소드
    	function getMoreList(data){
    	 //data를 json으로 바꾸기
		const obj = JSON.parse(data);
		 //console.log(obj[0]);
    	var item_template = document.querySelector("#event_template").innerHTML;
    	var resultHTML = "";

    	for (var i = 0; i < obj.length; i++) {
    		resultHTML += item_template.replace("{src}", obj[i].save_file_name)
    									.replace("{alt}", obj[i].description)
    									.replace("{title}",obj[i].description)
    									.replace("{place}",	obj[i].place_name)
    									.replace("{description}",obj[i].content)
    	}
    	//console.log(resultHTML);
    	var ul = document.querySelector(".wrap_event_box").firstElementChild;
    	ul.insertAdjacentHTML('beforeend',resultHTML);
    }
	
    
    	//더보기 클릭했을때 ajax호출
   		 var btn = document.getElementById("btn");
   		 btn.addEventListener("click",function(e) {

          var start = document.querySelector(".wrap_event_box").firstElementChild.childElementCount;
          //console.log(start);
          ajaxMoreContent(start);
        });
    
   		 
   		//무한슬라이딩
   	  var ul = document.querySelector('.visual_img');
      var firstItemClone = ul.firstElementChild.cloneNode(true);
      ul.appendChild(firstItemClone);//첫번째 li를 끝에 추가
      ul.style.width = (${promotionCount}+1)*600+'px';//ul크기 설정
     
      
      function move(){
		//이미지 번호매기는 변수
          var curIndex = 0;

          setInterval(function(){
              ul.style.transition = '3s'; //움직이는 시간
              ul.style.transform = "translate3d(-"+600*(curIndex+1)+"px, 0px, 0px)";

              curIndex++;
			//맨 마지막 그림에 도달했을때
              if(curIndex === ${promotionCount}+1 ){
                  setTimeout(function(){
                      ul.style.transition = '0s';
                      ul.style.transform = "translate3d(0px, 0px, 0px)";
                  },201);
                  curIndex = 0;
              }

          },3000);
      }
   		 
      document.addEventListener("DOMContentLoaded",function(){
          move();
      });
      
   		 
</script>
</html>