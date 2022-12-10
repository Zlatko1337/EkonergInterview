<div class="col-sm-3 col-md-9 col-lg-9">
	<table class="table table-hover table-dark">
		<thead>
			<tr>
				<th>Naselje</th>
				<th>Broj stanovnika</th>
				<th class="d-none">Županija</th>
			</tr>
		</thead>
		<tbody>			
		<#list naselja as naselje>
			<tr class='clickable-row' data-href='/naselje/edit/${naselje.id}'}'>
				<td>${(naselje.naselje)!}</td>
				<td>${(naselje.brojStanovnika)!}</td>
				<td class="d-none">${(naselje.zupanija.naziv)!}</td>
			</tr>  
		</#list>
		</tbody>
	</table>
	<br>
</div>