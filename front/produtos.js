const tabelaProdutos = document.getElementById('tabelaProdutos').querySelector('tbody');
const apiEndpoint = 'http://localhost:8081';

// Carregar tarefas ao carregar a página
async function carregarProdutos() {

    const listarProdutos = `http://localhost:8081/products`;

    try {
        const response = await fetch(listarProdutos,{
                method:'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
        });
        const produtos = await response.json();
        console.log(produtos);
        // Adiciona cada produto na tabela
        produtos.forEach(produto => {
            const novaLinha = document.createElement('tr');
            novaLinha.innerHTML = `
                <td>${produto.name}</td>
                <td>R$ ${produto.value}</td>
            `;
            tabelaProdutos.appendChild(novaLinha);
        });
    } catch (error) {
        console.error('Erro ao carregar produtos:', error);
    }
}



// Carregar as tarefas inicialmente
carregarProdutos();

