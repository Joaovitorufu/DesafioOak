document.querySelector('form').addEventListener('submit', function (event) {
    event.preventDefault(); // Evita o comportamento padrão de envio do formulário

    const formData = getFormData();
    console.log(formData); // Exibe os dados no console
    
    const apiEndpoint = 'http://localhost:8081';
    const urlAddProduct = apiEndpoint + `/products`;

    fetch(urlAddProduct, { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(data => {
        console.log('Tarefa salva com sucesso:', data);
        window.location.href = "produtos.html";
        window.alert('Cadastro Efetuado com sucesso!');
    })
    .catch(error => {
        console.error('Erro ao salvar a tarefa:', error);
    });
});

function getFormData() {
    // Seleciona os campos do formulário
    const productName = document.querySelector('#productName').value.trim();
    const productDescription = document.querySelector('#productDescription').value.trim();
    const productPrice = parseFloat(document.querySelector('#productPrice').value.trim());
    var availability = document.querySelector('input[name="availability"]:checked')?.value;
    console.log(availability);
    
    if(availability == "sim"){
        availability = true;
    }else if(availability == "nao"){
        availability = false;
    }
    console.log(availability)

    // Retorna os dados como um objeto
    return {
        name: productName,
        description: productDescription,
        price: productPrice,
        avaliable: availability
    };
}