<html>
    <head>
        <title>Spring MVC - Ajax</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <style>
            body { background-color: #eee; font: helvetica; }
            #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
            .green { font-weight: bold; color: green; }
            .message { margin-bottom: 10px; }
            label { width:70px; display:inline-block;}
            .hide { display: none; }
            .error { color: red; font-size: 0.8em; }
        </style>
    </head>
    <body>

        <div id="container">

            <h2>Submit new Shop</h2>

            <button onclick="sendPostValues();">send values</button><br/><br/>
            <div id="personFormResponse" class="green"> </div>    
        </div>


        <script type="text/javascript">
  
            function sendPostValues(){
                /*
              $.post('rest/kfc/brands/', 
                  //{"name":"kfc-kampar","staffName":["mkyong1","mkyong2"]}, 
                  '{"name":"munky"}',
                  function(response) {
                      $('#personFormResponse').text(response.name);
                  }, 'json');              
                 */
                /*
              $.ajax({
                  type: "POST",
                  headers: { 
                      'Accept': 'application/json',
                      'Content-Type': 'application/json' 
                  },
                  'url': 'rest/test',
                  'data':  '{"name":"munky"}',
                  'dataType': 'json',
                  'success': function(response) {
                      $('#personFormResponse').text(response.name);
                  },
                  statusCode: {
                      401:function() { 
                          $('#personFormResponse').css('color', 'red');
                          $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                      }
                  },
                  'fail' : function(data, textStatus, errorThrown) {
                      $('#personFormResponse').css('color', 'red');
                      $('#personFormResponse').text(textStatus);
                      console.log(data);
                      console.log(textStatus);
                      console.log(textStatus);
                      console.log(errorThrown);
                  }
              });
                 */
                $.ajax({
                    type: "GET",
                    headers: { 
                        'Accept': 'application/json',
                        'Content-Type': 'application/json' 
                    },
                    'url': 'rest/open/educational-scenario-v-3',                        
                    'dataType': 'json',            
                    'success': function(response) {
                        console.debug(response);                
                        $('#personFormResponse').text("OK");                                
                    },
                    statusCode: {
                        401:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                        }
                    },
                    'fail' : function(data, textStatus, errorThrown) {
                        $('#personFormResponse').css('color', 'red');
                        $('#personFormResponse').text(textStatus);
                        console.log(data);
                        console.log(textStatus);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        
            /* JSONP REQUEST
             * 
             * $.ajax({
                  type: "GET",
                  headers: { 
                      'Accept': 'application/json',
                      'Content-Type': 'application/json' 
                  },
                  'url': 'http://localhost:8080/SpringMVC/rest/open/educational-scenario-v-3',            
                  'dataType': 'jsonp',
                              'crossdomain' : true,
                              'jsonpCallback' : 'callback',
                  'success': function(response) {
                      console.log(response);
                  },
                  statusCode: {
                      401:function() { 
                          $('#personFormResponse').css('color', 'red');
                          $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                      }
                  },
                  'fail' : function(data, textStatus, errorThrown) {
                      $('#personFormResponse').css('color', 'red');
                      $('#personFormResponse').text(textStatus);
                      console.log(data);
                      console.log(textStatus);
                      console.log(textStatus);
                      console.log(errorThrown);
                  }
              });
             */
             function list() {
                $.ajax({
                    type: "GET",
                    headers: { 
                        'Accept': 'application/json',
                        'Content-Type': 'application/json' 
                    },
                    'url': 'http://taurus.isti.cnr.it:8080/rest/list',                        
                    'dataType': 'json',            
                    'success': function(response) {
                        console.debug(response);                
                        $('#personFormResponse').text("OK");                                
                    },
                    statusCode: {
                        401:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                        }
                    },
                    'fail' : function(data, textStatus, errorThrown) {
                        $('#personFormResponse').css('color', 'red');
                        $('#personFormResponse').text(textStatus);
                        console.log(data);
                        console.log(textStatus);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
             }
             
            function login(psw) { 
                $.ajax({
                    type: "POST",                  
                    url: 'rest/login',
                    data :  { j_username : "munky", j_password : psw},                    
                    statusCode: {
                        401:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                        },
                       200 : function() {
                           $('#personFormResponse').css('color', 'green');
                           $('#personFormResponse').text("Logged In");
                       }
                    }
                });
            }
            
            function logout() {
                $.ajax({
                    type: "GET",
                    headers: { 
                        'Accept': 'application/json',
                        'Content-Type': 'application/json' 
                    },
                    'url': 'rest/logout',                        
                    'dataType': 'json',            
                    'success': function(response) {
                        console.debug(response);                
                        $('#personFormResponse').text("LOGGED OUT");                                
                    },
                    statusCode: {
                        401:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                        },
                        200:function() { 
                            $('#personFormResponse').css('color', 'green');
                            $('#personFormResponse').text("Logged Out");
                        }
                    },
                    'fail' : function(data, textStatus, errorThrown) {
                        $('#personFormResponse').css('color', 'red');
                        $('#personFormResponse').text("textStatus");
                        console.log(data);
                        console.log(textStatus);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
            
            function save() {
                var json = '{"Task":{"Name":"name ","Type":"null","Description":"null","SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Access Educational Application"},"SiblingRight":{"name":"Access Application"},"SubTask":{"Task":[{"Name":"name ","Type":"Edit","Description":"null","TemporalOperator":{"name":"Disabling"},"Parent":{"name":"Login Application"},"SiblingRight":{"name":"Trigger Login"},"SubTask":{"Task":[{"Name":"name ","Type":"Edit","Description":"null","TemporalOperator":{"name":"Interleaving"},"Parent":{"name":"Enter Login data"},"SiblingRight":{"name":"Enter Password"},"Identifier":"Enter Login","Category":"interaction","Iterative":true,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Edit","Description":"null","Parent":{"name":"Enter Login data"},"SiblingLeft":{"name":"Enter Login"},"Identifier":"Enter Password","Category":"interaction","Iterative":true,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Enter Login data","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Control","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Login Application"},"SiblingLeft":{"name":"Enter Login data"},"SiblingRight":{"name":"Check Login Data"},"Identifier":"Trigger Login","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Login","Description":"null","Parent":{"name":"Login Application"},"SiblingLeft":{"name":"Trigger Login"},"Identifier":"Check Login Data","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Login Application","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Access Educational Application"},"SiblingLeft":{"name":"Login Application"},"SubTask":{"Task":[{"Name":"name ","Type":"Feedback","Description":"null","Precondition":{"conditionGroupOrConditionLiteral":[{"ConditionGroup":{"conditionGroupOrConditionLiteral":[{"ConditionLiteral":{"object":"loggedIn","value":null}},{"ConditionLiteral":{"object":null,"value":"false"}}],"operator":"eq"}}],"operator":"and"},"TemporalOperator":{"name":"Choice"},"Parent":{"name":"Access Application"},"SiblingRight":{"name":"Login ok"},"Object":[{"name":"loggedIn","class":"Boolean","type":null,"access_mode":null,"cardinality":null}],"Identifier":"Deny Login","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name","Type":"None","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Access Application"},"SiblingLeft":{"name":"Deny Login"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Login ok"},"SiblingRight":{"name":"Navigate application"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","Precondition":{"conditionGroupOrConditionLiteral":[{"ConditionGroup":{"conditionGroupOrConditionLiteral":[{"ConditionLiteral":{"object":"loggedIn","value":null}},{"ConditionLiteral":{"object":null,"value":"true"}}],"operator":"eq"}}],"operator":"and"},"TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Show initial overview"},"SiblingRight":{"name":"Show last login"},"Object":[{"name":"loggedIn","class":"Boolean","type":null,"access_mode":null,"cardinality":null}],"Identifier":"Get student data","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Visualise","Description":"null","TemporalOperator":{"name":"Interleaving"},"Parent":{"name":"Show initial overview"},"SiblingLeft":{"name":"Get student data"},"SiblingRight":{"name":"show student timetable"},"Identifier":"Show last login","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Visualise","Description":"null","Parent":{"name":"Show initial overview"},"SiblingLeft":{"name":"Show last login"},"Identifier":"show student timetable","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Show initial overview","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Login ok"},"SiblingLeft":{"name":"Show initial overview"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"Choice"},"Parent":{"name":"Navigate application"},"SiblingRight":{"name":"Subscribe course"},"SubTask":{"Task":[{"Name":"name ","Type":"Control","Description":"null","TemporalOperator":{"name":"SequentialEnabling"},"Parent":{"name":"Overview"},"SiblingRight":{"name":"Show overview"},"Identifier":"Select overview","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Visualise","Description":"null","Parent":{"name":"Overview"},"SiblingLeft":{"name":"Select overview"},"Identifier":"Show overview","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Overview","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"Choice"},"Parent":{"name":"Navigate application"},"SiblingLeft":{"name":"Overview"},"SiblingRight":{"name":"UnSubscribe course"},"SubTask":{"Task":[{"Name":"name ","Type":"Control","Description":"null","TemporalOperator":{"name":"SequentialEnabling"},"Parent":{"name":"Subscribe course"},"SiblingRight":{"name":"Select course to subscribe"},"Identifier":"Select subscribe","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Subscribe course"},"SiblingLeft":{"name":"Select subscribe"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Select course to subscribe"},"SiblingRight":{"name":"Access course"},"Identifier":"Show courses to subscribe","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Select course to subscribe"},"SiblingLeft":{"name":"Show courses to subscribe"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"Choice"},"Parent":{"name":"Access course"},"SiblingRight":{"name":"Subscribe selected course"},"SubTask":{"Task":[{"Name":"name ","Type":"Selection/Single_Choice","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Select courses to subscribe"},"SiblingRight":{"name":"Show course to subscribe info"},"Identifier":"Select course to subscribe info","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Visualise","Description":"null","TemporalOperator":{"name":"Disabling"},"Parent":{"name":"Select courses to subscribe"},"SiblingLeft":{"name":"Select course to subscribe info"},"SiblingRight":{"name":"Close course info"},"Identifier":"Show course to subscribe info","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Control","Description":"null","Parent":{"name":"Select courses to subscribe"},"SiblingLeft":{"name":"Show course to subscribe info"},"Identifier":"Close course info","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Select courses to subscribe","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Selection/Single_Choice","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Access course"},"SiblingLeft":{"name":"Select courses to subscribe"},"SiblingRight":{"name":"Insert selected course"},"Identifier":"Subscribe selected course","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Access course"},"SiblingLeft":{"name":"Subscribe selected course"},"Identifier":"Insert selected course","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Access course","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Select course to subscribe","Category":"abstraction","Iterative":true,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Subscribe course","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"Disabling"},"Parent":{"name":"Navigate application"},"SiblingLeft":{"name":"Subscribe course"},"SiblingRight":{"name":"Logout"},"SubTask":{"Task":[{"Name":"name ","Type":"Control","Description":"null","TemporalOperator":{"name":"SequentialEnabling"},"Parent":{"name":"UnSubscribe course"},"SiblingRight":{"name":"Select course to unsubscribe"},"Identifier":"Select unsubscribe","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"UnSubscribe course"},"SiblingLeft":{"name":"Select unsubscribe"},"SubTask":{"Task":[{"Name":"name ","Type":"Visualise","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Select course to unsubscribe"},"SiblingRight":{"name":"Access Course to Unsubscribe"},"Identifier":"Show courses to unsubscribe","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Select course to unsubscribe"},"SiblingLeft":{"name":"Show courses to unsubscribe"},"SubTask":{"Task":[{"Name":"name ","Type":"null","Description":"null","TemporalOperator":{"name":"Choice"},"Parent":{"name":"Access Course to Unsubscribe"},"SiblingRight":{"name":"UnSubscribe selected course"},"SubTask":{"Task":[{"Name":"name ","Type":"Selection/Single_Choice","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Select Courses to unsubscribe"},"SiblingRight":{"name":"Show course info"},"Identifier":"Select course info","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Visualise","Description":"null","TemporalOperator":{"name":"Disabling"},"Parent":{"name":"Select Courses to unsubscribe"},"SiblingLeft":{"name":"Select course info"},"SiblingRight":{"name":"Close"},"Identifier":"Show course info","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Control","Description":"null","Parent":{"name":"Select Courses to unsubscribe"},"SiblingLeft":{"name":"Show course info"},"Identifier":"Close","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Select Courses to unsubscribe","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Selection/Single_Choice","Description":"null","TemporalOperator":{"name":"SequentialEnablingInfo"},"Parent":{"name":"Access Course to Unsubscribe"},"SiblingLeft":{"name":"Select Courses to unsubscribe"},"SiblingRight":{"name":"Remove selected course"},"Identifier":"UnSubscribe selected course","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"null","Description":"null","Parent":{"name":"Access Course to Unsubscribe"},"SiblingLeft":{"name":"UnSubscribe selected course"},"Identifier":"Remove selected course","Category":"application","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Access Course to Unsubscribe","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Select course to unsubscribe","Category":"abstraction","Iterative":true,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"UnSubscribe course","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},{"Name":"name ","Type":"Control","Description":"null","Parent":{"name":"Navigate application"},"SiblingLeft":{"name":"UnSubscribe course"},"Identifier":"Logout","Category":"interaction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Navigate application","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Login ok","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":" "}]},"Identifier":"Access Application","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"}]},"Identifier":"Access Educational Application","Category":"abstraction","Iterative":false,"Optional":false,"PartOfCooperation":false,"Frequency":"null"},"NameTaskModelID":"Access Educational Application","role":null}';
                $.ajax({
                    headers: { 
                        'Accept': 'application/json',
                        'Content-Type': 'application/json' 
                    },
                    type: "POST",                  
                    url: 'rest/save',
                    dataType : 'json',   
                    data :  '{ "type" : "SAVE", "filename" : "prova", "task" : '+json+'}',                    
                    statusCode: {
                        400:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 400 - Bad Request");
                        },
                        401:function() { 
                            $('#personFormResponse').css('color', 'red');
                            $('#personFormResponse').text("HTTP Status 401 - Unauthorized - authentication required");
                        },
                       200 : function() {
                           $('#personFormResponse').css('color', 'green');
                           $('#personFormResponse').text("Task Saved");
                       }
                    }
                });
            }
        </script>

    </body>
</html>