<@layout>

	<h4 style="color:white;">Zupanija ${zupanija.naziv}</h4>
	<form action="/zupanija/${zupanija.id}" method="post">		
		<div class="form-group">
			<label for="naziv">Naziv</label>
			<input class="form-control" type="text" id="naziv" name="naziv" placeholder="Unesi naziv" value="${zupanija.naziv}"> 
		</div><br>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		<button type="submit" class="btn btn-primary" formaction="/zupanija/delete/${zupanija.id}">Delete</button>
	</form>


</@layout>