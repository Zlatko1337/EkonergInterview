<@layout>

	<h4 style="color:white;">Naselje ${naselje.naselje}</h4>
	<form action="/naselje/${naselje.id}" method="post">		
		<div class="form-group">
			<input class="form-control" type="text" id="brojStanovnika" name="brojStanovnika" placeholder="Unesi broj stanovnika" value="${naselje.brojStanovnika}"> 
		</div><br>
		
		<button type="submit" class="btn btn-primary">Save</button>
	</form>

</@layout>