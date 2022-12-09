<@layout>
	
	<script src="js/main.js"></script>
	
	<div class="row">
		<div class="col-sm-4 col-md-4 col-lg-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Top 3 županije po broju stanovnika</th>
					</tr>
				</thead>
				<tbody>			
				<#list zupanijeTop as zupanija>
					<tr>
						<td>${(zupanija.naziv)!}</td>
					</tr>  
				</#list>
				</tbody>
			</table>
		</div>
	</div>
	
	<br>
	
	<div class="row">
		<div class="col-sm-3 col-md-3 col-lg-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Županije</th>
					</tr>
				</thead>
				<tbody>			
				<#list zupanije as zupanija>
					<tr class='clickable-row' data-href='/${zupanija.id}'}'>
						<td class="d-none">${(zupanija.id)!}</td>
						<td>
							<div style="float:left;width:80%;">${(zupanija.naziv)!}</div>
							<div style="float:right;width:20%;"><a href="/zupanija/edit/${zupanija.id}" class="btn btn-primary">Edit</a></div></td>
					</tr>  
				</#list>
				</tbody>
			</table>
			<br>
		</div>		
		
		<#include "naselja.ftl"> 

	</div>

</@layout>