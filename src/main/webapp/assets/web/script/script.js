function onclickbtn() {
    document.getElementById("search-modal").classList.toggle("show");
}
window.onscroll = function(){scrollFunction() }
function scrollFunction(){
    if(document.body.scrollTop > 100 || document.documentElement.scrollTop > 100){
        document.getElementById("nav-menu").style.position = "fixed";
        document.getElementById("nav-menu").style.top = "0";
        document.getElementById("wrapper").style.marginTop = "70px";
       
     }else{
        document.getElementById("nav-menu").style.position = "";
        document.getElementById("wrapper").style.marginTop = "15px";
    
     }
}


			