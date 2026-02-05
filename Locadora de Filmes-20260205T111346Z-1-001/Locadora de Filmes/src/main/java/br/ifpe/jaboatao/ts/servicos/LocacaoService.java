package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}

	public static void main(String[] args) {
		//Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Maria");
		Usuario usuario2 = new Usuario("Xiao");
		Filme filme = new Filme("Titulo 01CirculoFogo", 1, 11.00);
		Filme filme2 = new Filme("gorilagori", 2, 20.00);
		//Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
		Locacao locacao2 = service.alugarFilme(usuario2, filme2);
		//VerificaçãO
		System.out.println("tá pegando cria");
			//valor
		System.out.println("Valores:");
		System.out.println(locacao.getValorLocacao() == 11.00);
		System.out.println(locacao2.getValorLocacao() == 20.00);
			//data
		System.out.println("Datas:");
		System.out.println("primero mano:");
		System.out.println(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.boDatasIguais(locacao.getDataRetorno(), DataUtils.incrementarQntDias(1)));
		System.out.println("segundo mano:");
		System.out.println(DataUtils.boDatasIguais(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.boDatasIguais(locacao2.getDataRetorno(), DataUtils.incrementarQntDias(1)));
		
		System.out.println("");
		System.out.println("");
		System.out.println(usuario.getNome() == "Maria");
		System.out.println(usuario2.getNome());
		
		System.out.println(filme.getTitulo() == "Titulo 01CirculoFogo");
		System.out.println(filme2.getTitulo());
		
		System.out.println(filme.getEstoque() == 1);
		System.out.println(filme2.getEstoque());
		
	}
}