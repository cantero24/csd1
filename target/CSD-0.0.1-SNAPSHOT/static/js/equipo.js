

$(document).ready(function() {
	
	$('.btn-borrar-1').on('click', function(){
		var id = $(this).parents('tr').data('id');
		$('#id-borrar').val(id);
		
		
		$('#form-equipos .modal-title').text ("Confirmar borrado....");
				
		$('#modal-equipos-1').modal('show');
		
	});
	
	$('#btn-borrar').on('click', function(){
		var id = $('#id-borrar').val();;
		
		$.ajax({
			url : "equipos/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var equipos = parseInt( $('#cantidades-equipos').text() );
		    	$('#cantidades-equipos').text(equipos - 1);
		    	$('#modal-equipos-1').modal('hide');
		    }
		});
	});
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'equipos/'+id;
		
		$.get(url)
			.done(function(equipo){
				
				$('#id').val(equipo.id);
				$('#nombre').val(equipo.nombre);
				$('#estadio').val(equipo.estadio);
				$('#presupuesto').val(equipo.presupuesto);
				$('#federaciones').val(equipo.federaciones);
				$('#form-equipos .modal-title').text ("Editando....");
				
				$('#modal-equipos').modal('show');
			});
	});
});

