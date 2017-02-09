$(document).ready(function() {
	
	$('.btn-borrar-1').on('click', function(){
		var id = $(this).parents('tr').data('id');
		$('#id-borrar').val(id);
		
		
		$('#form-federacion .modal-title').text ("Confirmar borrado....");
				
		$('#modal-federacion-1').modal('show');
		
	});
	
	$('#btn-borrar').on('click', function(){
		var id = $('#id-borrar').val();;
		
		$.ajax({
			url : "federacion/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var federacion = parseInt( $('#cantidades-federacion').text() );
		    	$('#cantidades-federacion').text(federacion - 1);
		    	$('#modal-federacion-1').modal('hide');
		    }
		});
	});
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'federacion/'+id;
		
		$.get(url)
			.done(function(federacion){
				
				$('#id').val(federacion.id);
				$('#nombre').val(federacion.nombre);
				$('#pais').val(federacion.pais);
				$('#form-federacion .modal-title').text ("Editando....");
				
				$('#modal-federacion').modal('show');
			});
	});
});

