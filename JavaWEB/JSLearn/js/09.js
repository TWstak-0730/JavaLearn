//click
        document.querySelector("#b2").addEventListener('click',function(){
            console.log("b2 clicked!");            
        });

        //mouse
        document.querySelector("#last").addEventListener('mouseenter',function(){
            console.log("last enter"); 
        });

        document.querySelector("#last").addEventListener('mouseleave',function(){
            console.log("last leave"); 
        });

        //key
        document.querySelector("#username").addEventListener('keyup',function(){
            console.log("up");
        });
        document.querySelector("#username").addEventListener('keydown',function(){
            console.log("down");
        });

        //blur
        document.querySelector("#age").addEventListener('blur',function(){
            console.log("失去焦点");
        });

        //focus
        document.querySelector("#age").addEventListener('focus',function(){
            console.log("获得焦点");
        });

        //input
        document.querySelector("form").addEventListener('input',function(){
            console.log("输入内容");
        });

        //submit
        document.querySelector("form").addEventListener('submit',function(){
            //event.preventDefault(); // 阻止表单默认提交
            alert("提交");
        });