

$(document).ready(function() {
	
	$('.btn-borrar-1').on('click', function(){
		var id = $(this).parents('tr').data('id');
		$('#id-borrar').val(id);
		
		
		$('#form-equipos .modal-title').text ("Confirmar borrado....");
				
		$('#modal-jugador-1').modal('show');
		
	});
	
	$('#btn-borrar').on('click', function(){
		var id = $('#id-borrar').val();;
		
		$.ajax({
			url : "jugador/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var jugador = parseInt( $('#cantidades-jugador').text() );
		    	$('#cantidades-jugador').text(jugador - 1);
		    	$('#modal-jugador-1').modal('hide');
		    }
		});
	});
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'jugador/'+id;
		
		$.get(url)
			.done(function(jugador){
				
				$('#id').val(jugador.id);
				$('#nombre').val(jugador.nombre);
				$('#edad').val(jugador.edad);
				$('#goles').val(jugador.goles);
				$('#equipos').val(jugador.equipos);
				$('#form-equipos .modal-title').text ("Editando....");
				
				$('#modal-jugador').modal('show');
			});
	});
	

});

