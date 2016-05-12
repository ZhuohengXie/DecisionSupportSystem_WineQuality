<%-- 
    Document   : newjsp
    Created on : Apr 8, 2015, 8:20:05 PM
    Author     : Yu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="view.js"></script>
    </head>
<body id="main_body" >
        
         <img id="top" src="top.png" alt="">
         <div id="form_container">
         <h1><a>Wine Quality Prediction</a></h1>
         <div class="form_description">
               <h2>Wine Quality Prediction</h2>
               <p>Get your wine Quality</p>
                                </div>		
         <div align="center">
              <p>&nbsp;</p>
           <h3><strong> The attributes of your wine:</strong></h3>
           <table class="appnitro">
             <tr>
               <th width="160" height="30"><div align="left">Option</div></th>
               <th width="149"><div align="left">Context</div></th>
               </tr>
             <tr>
               <td height="40"><strong>Fixed Acidity</strong></td>
               <td><%=request.getSession().getAttribute("opt1") %> </td>
               </tr>
             <tr>
               <td height="35"><strong>Volatile Acidity</strong></td>
               <td><%=request.getSession().getAttribute("opt2") %> </td>
               </tr>
             <tr>
               <td height="34"><strong>Citric Acid</strong></td>
               <td><%=request.getSession().getAttribute("opt3") %> </td>
               </tr>
             <tr>
               <td height="35"><strong>Residual Sugar</strong></td>
               <td><%=request.getSession().getAttribute("opt4") %> </td>
               </tr>
             <tr>
               <td height="33"><strong>Chlorides</strong></td>
               <td><%=request.getSession().getAttribute("opt5") %> </td>
               </tr>
             <tr>
               <td height="36"><strong>Free Sulfur Dioxide</strong></td>
               <td><%=request.getSession().getAttribute("opt6") %> </td>
               </tr>
             <tr>
               <td height="36"><strong>Total Sulfur Dioxide</strong></td>
               <td><%=request.getSession().getAttribute("opt7") %> </td>
               </tr>
             <tr>
               <td height="35"><strong>Density</strong></td>
               <td><%=request.getSession().getAttribute("opt8") %> </td>
               </tr>
             <tr>
               <td height="40"><strong>pH</strong></td>
               <td><%=request.getSession().getAttribute("opt9") %> </td>
               </tr>
             <tr>
               <td height="39"><strong>Sulphates</strong></td>
               <td><%=request.getSession().getAttribute("opt10") %> </td>
               </tr>
             <tr>
               <td height="30"><strong>Alcohol</strong></td>
               <td><%=request.getSession().getAttribute("opt11") %> </td>
             </tr>
             <tr>
               <td height="30"><strong>Type</strong></td>
               <td><%=request.getSession().getAttribute("opt12") %> </td>
             </tr>
           </table>
           <p>&nbsp;</p>
           <h3><strong> The quality of your wine:</strong></h3>
           <form name="form1" method="post" action="">
               <h2><label for="Quality"><strong><%=request.getSession().getAttribute("Quality") %></strong></label></h2>
             
             <P>
              The analysis performed on the sample dataset can be summarised as below:<br/><br/>
              <table class="appnitro">
             <tr>
               <th width="160" height="30"><div align="left">Quality</div></th>
               <th width="149"><div align="left">Probability</div></th>
               </tr>
             <tr>
               <td height="35"><strong>3</strong></td>
               <td><%=request.getSession().getAttribute("Probability3") %> </td>
               </tr>
             <tr>
               <td height="34"><strong>4</strong></td>
               <td><%=request.getSession().getAttribute("Probability4") %> </td>
               </tr>
             <tr>
               <td height="35"><strong>5</strong></td>
               <td><%=request.getSession().getAttribute("Probability5") %> </td>
               </tr>
             <tr>
               <td height="33"><strong>6</strong></td>
               <td><%=request.getSession().getAttribute("Probability6") %> </td>
               </tr>
             <tr>
               <td height="36"><strong>7</strong></td>
               <td><%=request.getSession().getAttribute("Probability7") %> </td>
               </tr>
             <tr>
               <td height="36"><strong>8</strong></td>
               <td><%=request.getSession().getAttribute("Probability8") %> </td>
               </tr>
             <tr>
               <td height="35"><strong>9</strong></td>
               <td><%=request.getSession().getAttribute("Probability9") %> </td>
               </tr>
           </table>

pH value is considered an important parameter when determining the quality of the Wine.The analysis over the samples however indicate that there is no specific values of pH which provides bias for quality ratings and a higher density of Red Wine samples did indicate a higher PH values as compared to White wine samples for the same quality ratings.These pH value however was found to be optimum between a value of 3.0 and 3.5 .A pH value of higher than 3.5 tends to exhibit a higher SO2 values which can be concern for people with concerns of health issues with SO2.Samples with higher alcohol content did exhibit lower SO2 counts and also White wine samples exhibited a higher level of SO2 components as compared to Red wine for the same level of Alcohol.<br/>

Some of the learnings from the analysis were as follows:<br/>

The understanding that Red Wine generally exhibits more SO2 properties than White wine seems to be not true as per the samples considered.The analysis proves that White wine exhibitis a higher level of SO2 properties </br>
It always seemed that pH value was a key factor in detemining the quality of the wines but from the analysis ,it seems that pH value do not exhibit any patterns which can be utilized as akey determinstic variable for wine quality testing by sensory analysis.The understanding that Red Wine generally exhibits more SO2 properties than White wine seems to be not true as per the samples considered.The analysis proves that White wine exhibitis a higher level of SO2 properties </br>
<br/>
From the samples analyzed,the wines with higher Alcohol content exhibited lower SO2 content as compared with samples with lower Alcohol content. 4.For the buyer conscious of the sugar content in the wines,White wine exhibits more residual sugar and at we have seen spikes in the residual sugar for certain ranges of the Free and Total SO2 primarily with White wine.The understanding that Red Wine generally exhibits more SO2 properties than White wine seems to be not true as per the samples considered.The analysis proves that White wine exhibitis a higher level of SO2 properties </br>
<br/>
A limitation of the current analysis is that the current data consists of samples collected from a specific portugal region.It will be intresting to obtain datasets across various wine making regions to eliminate any bias created by any secific qualities of the product,   
                 
  <br/>               
             </P>
             
             
           </form>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
         </div>
         <div id="footer">
              IS2154 Decision Analysis & Decision Support System
            </div>
            </div>
             <img id="bottom" src="bottom.png" alt="">
    </body>
</html>
