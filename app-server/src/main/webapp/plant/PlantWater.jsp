<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>growing</title>
</head>

<style>

body{
  margin: 0;
  padding: 0;
  background-color: #95d0ff;
}
.container{
  position: absolute;
  margin: auto;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
    width:350px;
    height:510px;
}
.sun{
  height: 0;
  width: 0;
  position: absolute;
  top: 50px;
  left: 20px;
}
.circle{
  height: 44px;
  width: 44px;
  position: absolute;
  top: 3px;
  left: 3px;
  background-color: #ff0;
  border-radius: 50%;
}
.sunrays{
  height: 50px;
  width: 50px;
  position: relative;
  background-color: #ffdd4a;
  box-shadow: 0 0 20px 3px #ff8,
        0 0 80px 10px #ff6;
  animation: rotate 12s linear infinite;
}
@keyframes rotate{
  100%{transform: rotate(360deg);}
}
.sunrays:before{
  content: '';
  height: 50px;
  width: 50px;
  position: absolute;
  background-color: #ffdd4a;
  transform: rotate(30deg);
}
.sunrays:after{
  content: '';
  height: 50px;
  width: 50px;
  position: absolute;
  background-color: #ffdd4a;
  transform: rotate(60deg);
}
.shadow{
  position: absolute;
  width: 110px;
  height: 14px;
  border-radius: 50%;
  background-color: rgba(0, 0, 0,0.1);
  bottom: 95px;
  left: 135px;
}
.pot{
  position: absolute;
  width: 70px;
  height: 0;
  border-left: 12px solid transparent;
  border-right: 12px solid transparent; 
  border-top: 60px solid #FF7043;
  bottom: 104px;
  left: 125px;
  z-index: 2;
}
.pot:before{
  position: absolute;
  content: '';
  width: 87px;
  height: 0;
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;  
  border-top: 9px solid #F4511E;
  top: -60px;
  left: -12px;
}
.pot:after{
  position: absolute;
  content: '';
  width: 110px;
  height: 18px;
  top: -78px;
  left: -20px;
  border-radius: 5px;
  background-color: #FF7043;
}
.water-jar{
  position: absolute;
  width: 40px;
  height: 55px;
  background-color: #c5f;
  border-radius: 5px;
  bottom: 235px;
  left: 65px;
  opacity: 0;
  box-shadow: inset -9px 0 15px #cc70ff;
  animation: show 10s linear;
}
@keyframes show{
  5%{opacity: 1;}
  7%{transform: rotate(40deg);}
  24%{opacity: 1;}
  25%{opacity: 0;}
}
.water-jar:before{
  position: absolute;
  content: '';
  width: 15px;
  height: 0;
  left: 40px;
  top: 5px;
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;  
  border-bottom: 40px solid #c6f;
  transform: rotate(65deg);
}
.water-jar:after{
  position: absolute;
  content: '';
  width: 20px;
  height: 30px;
  top: 5px;
  left: -20px;
  border-radius: 20px 0 0 20px;
  background-color: transparent;
  border: 5px solid #c5f;
  box-shadow: 70px -4px 0 -6px #c6f;
}
.water{
  position: absolute;
  width: 20px;
  height: 50px;
  border-radius: 50% 50% 0 0;
  border-right: 4px dashed #0bf;
  bottom: 180px;
  left: 115px;
  z-index: 1;
  opacity: 0;
  animation: water 10s linear;
}
@keyframes water{
  7%{opacity: 0;}
  8%{opacity: 1;}
  21%{opacity: 1;}
  22%{opacity: 0;}
}
.water:before{
  position: absolute;
  content: '';
  width: 45px;
  height: 52px;
  top: -2px;
  left: -10px;
  border-radius: 70% 80% 20% 0;
  border-right: 4px dashed #0bf;
  z-index: 1;
}
.water:after{
  position: absolute;
  content: '';
  width: 65px;
  height: 62px;
  top: -10px;
  left: -10px;
  border-radius: 70% 90% 28% 0;
  border-right: 4px dashed #0bf;
  z-index: 1;
}
.flower{
  position: absolute;
  bottom: 180px;
  left: 0;
  right: 0;
  margin: 0 auto;
  width: 50px;
  transform: rotate(180deg);
}
.stem{
  position: absolute;
  left: 25px;
  width: 5px;
  height: 0px;
  background: linear-gradient(-90deg, #0d0, #0a0);
  animation: grow 10s linear forwards;
}
@keyframes grow{
  25%{height: 0;}
  34%{height: 22px;}
  39%{height: 22px;}
  41%{height: 27px;}
  45%{height: 27px;}
  52%{height: 92px;}
  55%{height: 94px;}
  100%{height: 120px;}
}
.leaf{
  position: absolute;
  width: 25px;
  top: -10px;
  left: 18px;
  height: 38px;
  border-radius: 1% 100%;
  background: linear-gradient(70deg, #0e0, #0a0);
  transform-origin: bottom;
  transform: rotate(-110deg);
  animation: leaf-1 10s linear;
}
@keyframes leaf-1{
  0%{transform: scaleY(0) rotate(-180deg);}
  38%{transform: scaleY(0) rotate(-110deg);}
  50%{transform: scaleY(1) rotate(-110deg);}
}
.leaf:before{
  position: absolute;
  content: '';
  top: 18px;
  left: -33px;
  width: 30px;
  height: 45px;
  border-radius: 1% 100%;
  background: linear-gradient(70deg, #0e0, #0a0);
  transform: rotate(110deg);
  animation: leaf-2 10s linear;
}
@keyframes leaf-2{
  0%{transform: scaleY(0) rotate(110deg);}
  45%{transform: scaleY(0) rotate(110deg);}
  52%{transform: scaleY(1) rotate(110deg);}
}
.leaf:after{
  position: absolute;
  content: '';
  top: -20px;
  left: -60px;
  width: 25px;
  height: 35px;
  border-radius: 1% 100%;
  background: linear-gradient(70deg, #0e0, #0a0);
  transform-origin: bottom;
  animation: leaf-3 10s linear;
}
@keyframes leaf-3{
  0%{transform: scaleY(0);}
  55%{transform: scaleY(0);}
  72%{transform: scaleY(1);}
}
.dot{
  position: absolute;
  top: 147px;
  left: 24px;
  height: 15px;
  width: 15px;
  border-radius: 50%;
  background-color: #f8d545;
  box-shadow: 0 0 0 4px #d85,
        0 0 8px 4px #444,
        inset 0 0 8px #fd0;
  opacity: 0;
  animation: flower 10s linear forwards;
}
@keyframes flower{
  72%{opacity: 0;}
  74%{opacity: 1;}
  100%{opacity: 1;}
}
.petal{
  position: absolute;
  width: 0px;
  height: 40px;
  border-radius: 100% 0% 50% 50% /50% 0% 100% 50%;
  background: linear-gradient(
  185deg,
    #941346 0%,
    #E63B94 50%,
    #FF5AB0 75%,
    #FF7DC1 100%
  );
  opacity: 0;
  animation: petal 10s linear forwards;
}
@keyframes petal{
  72%{opacity: 0;}
  84%{opacity: 1; width: 40px;}
  100%{opacity: 1; width: 40px;}
}
.petal-1{
  top: 155px;
  left: -9px;
}
.petal-2{
  top: 125px;
  left: -18px;
  transform: rotate(60deg);
}
.petal-3{
  top: 105px;
  left: 5px;
  transform: rotate(120deg);
}
.petal-4{
  top: 110px;
  left: 35px;
  transform: rotate(180deg);
}
.petal-5{
  top: 140px;
  left: 42px;
  transform: rotate(240deg);
}
.petal-6{
  top: 160px;
  left: 18px;
  transform: rotate(300deg);
}
</style>
<script>
function nextWin(){
  location = "http://localhost:8080/apus/plant/list"
}
</script>
<body onLoad = "setTimeout('nextWin()',15000)">
<div class="container">
  <div class="sun">
    <div class="sunrays"></div>
    <div class="circle"></div>
  </div>
  <div class="shadow"></div>
  <div class="pot"></div>
  <div class="water-jar"></div>
  <div class="water"></div>
  <div class="flower">
    <div class="stem"></div>
    <div class="leaf"></div>
    <div class="petal petal-1"></div>
    <div class="petal petal-2"></div>
    <div class="petal petal-3"></div>
    <div class="petal petal-4"></div>
    <div class="petal petal-5"></div>
    <div class="petal petal-6"></div>
    <div class="dot"></div>
  </div>
</div>


</body>
</html>