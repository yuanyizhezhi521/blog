$(top.document.body).click(function f() {
        var imglist =[
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEGyACvbAAAfAFNTszo8583.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEH-ASBOWAAJjbNklQn0084.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEKOAY9QAABKIq7w073I866.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xELWABJ3AABEuAvcWDoY606.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEMeAWqatAAnNg-MU4fA145.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xENeAC4PnAAS9FyYlqb8291.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEQKAR4wLAAiiN_f6xR4361.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEReAZIcEACz0_GjJvJg103.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xETCAV7VLACHtwHLrHjQ900.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEVeAGZ-bAAI0-RiVQKQ321.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEW6AeWY_AAXWgEnTX0k104.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEYmAIDE4ABACNlbtXzE507.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEaCARePGAAWFvYVCY6g400.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEbmAYTWTAAdGdJU2j1Y774.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEeOAFwQnAAO4kppIe8w567.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEfSAMKnYAAf5rNB6bis175.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEgiAR0k2AAY6FjR6bEw663.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEl6AJP0DABMP_b7AP0I381.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEnGAPv0GABs7ZuXD-CI937.jpg",
            "http://47.102.110.105/group1/M00/00/00/rBECyF2xEo6AcpKaACRsX96ao6Y967.jpg"];
        var index =parseInt(Math.random()*(imglist.length-1));
        $(top.document.body).css('backgroundImage',"url("+imglist[index]+")");

       // style.backgroundImage +':'+ "url("+index+")";
        // $("body").prop("outerHTML");
       //  var b= $('#body');
       // alert(b)
    });
