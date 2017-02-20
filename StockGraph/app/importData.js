/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function importData(){
    d3.json("data/stock.json", function (data){
      var canvas = d3.select(".importData").append("svg")
              .attr("width",1000)
              .attr("height", 700);
      canvas.selectAll("rect")
              .data(data)
              .enter()
              .append("rect")
              .attr("width", function (d){                  
                  return d.rank * 60;       
              })
              .attr("height", 50)
              .attr("y", function (d,i){                  
                  return i * 70;       
              })
              .attr("fill", "red");
      
      canvas.selectAll("text")
              .data(data)
              .enter()
              .append("text")
              .attr("fill", "#hhffff")
              .attr("y", function (d,i){                  
                  return i * 80 + 20;       
              })
                      .attr("x", 5)
                      .text(function(d){
                          return d.name + " rank: " + d.rank;
                      })
      
    })
}