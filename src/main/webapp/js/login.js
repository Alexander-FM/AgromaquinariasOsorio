document.getElementById('formLogin').addEventListener('submit', (e) => {
    e.preventDefault();
  
    const correo = document.querySelector('input[name="correo"]').value.trim();
    const clave = document.querySelector('input[name="password"]').value.trim();
    const errorBox = document.querySelector('.error-text');
  
    if (!correo || !clave) {
      errorBox.innerHTML = '<p>Todos los campos son obligatorios.</p>';
      errorBox.style.display = 'block';
      return;
    }
    console.log({ correo, clave });
    fetch('http://localhost:3000/api/usuarios/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ correo, clave })
    })
      .then(res => res.json())
      .then(data => {
        if (data.usuario) {
          localStorage.setItem('usuario', JSON.stringify(data.usuario));
          // Redirigir según el rol
          if (data.usuario.ROL === 'ADMIN') {
            window.location.href = '../dashboard/dashboard.html';
          } else {
            window.location.href = '../index.html';
          }
        } else {
          errorBox.innerHTML = `<p>${data.error || 'Credenciales incorrectas'}</p>`;
          errorBox.style.display = 'block';
        }
      })
      .catch(() => {
        errorBox.innerHTML = '<p>Error en el servidor.</p>';
        errorBox.style.display = 'block';
      });
  });

  if (document.getElementById('btnRegistro')) {
    const btnRegistro = document.getElementById('btnRegistro');
  
    btnRegistro.addEventListener('click', (e) => {
      e.preventDefault();
  
      const form = document.getElementById('formRegistro');
      const errorBox = document.querySelector('#formRegistro .error-text');
      errorBox.innerHTML = '';
      errorBox.classList.remove('active');
  
      const nombre = form.nombre.value.trim();
      const correo = form.correo.value.trim();
      const clave = form.password.value.trim();
      const aceptaTerminos = form.cbx_terminos.checked;
  
      if (!nombre || !correo || !clave) {
        errorBox.innerHTML = '<p>Todos los campos son obligatorios.</p>';
        errorBox.classList.add('active');
        return;
      }
  
      if (!aceptaTerminos) {
        errorBox.innerHTML = '<p>Debes aceptar los Términos y Condiciones.</p>';
        errorBox.classList.add('active');
        return;
      }
  
      fetch('http://localhost:3000/api/usuarios', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          nombre,
          correo,
          clave: clave,
          rol: 'CLIENTE'
        })
      })
        .then(res => res.json())
        .then(data => {
          if (data.mensaje) {
            Swal.fire('Registro exitoso', '¡Tu cuenta ha sido creada!', 'success');
            form.reset();
          } else {
            Swal.fire('Error', data.error || 'No se pudo registrar.', 'error');
          }
        })
        .catch(() => {
          Swal.fire('Error', 'Hubo un problema con el servidor.', 'error');
        });
    });
  }
  
  
  