package signuplam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import signuplam.exception.NegocioException;
import signuplam.model.Colaborador;
import signuplam.model.Vinculo;
import signuplam.repository.ColaboradorRepository;
import signuplam.services.ColaboradorService;

public class ColaboradorServiceTest {

	@InjectMocks
	ColaboradorService service;

	@Mock
	ColaboradorRepository repository;

	List<Colaborador> listS1;
	Colaborador c;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		listS1 = new ArrayList<Colaborador>();
		listS1.add(new Colaborador());
		listS1.add(new Colaborador());
		listS1.add(new Colaborador());

		c = new Colaborador();
		c.setCpf("001.002.003-55");
		c.setNome("nome mock");
		c.setEmail("email.mock@gmail.com");
		c.setStatusCadastro(false);

		when(repository.findBySetor(1)).thenReturn(listS1);
		when(repository.findBySetor(null)).thenReturn(new ArrayList<Colaborador>());
		when(repository.findByCPF("001.002.003-55")).thenReturn(c);
		when(repository.findByCPF("")).thenReturn(null);
		when(repository.findByCPF("999.999.999-99")).thenReturn(null);
		when(repository.findByEmail("")).thenReturn(null);
		when(repository.findByEmail("asdasdasd@asd.asd")).thenReturn(null);
		when(repository.findByEmail("email.mock@gmail.com")).thenReturn(c);
	}

	@Test
	public void findByCpf() {
		Colaborador result = service.findByCPF("001.002.003-55");
		assertEquals(result.getCpf(), c.getCpf());
		verify(repository).findByCPF("001.002.003-55");
	}

	@Test
	public void findByCpfInvalido() {
		Colaborador result = service.findByCPF("999.999.999-99");
		assertTrue(result == null);
		verify(repository).findByCPF("999.999.999-99");
	}

	@Test
	public void findByEmail() {
		Colaborador result = service.findByEmail("email.mock@gmail.com");
		assertEquals(result.getCpf(), c.getCpf());
	}

	@Test
	public void findByEmailInvalido() {
		Colaborador result = service.findByEmail("email.mock@gmail.comxxx");
		assertTrue(result == null);
	}

	@Test
	public void validate() throws NegocioException {
		Colaborador novo = new Colaborador();
		novo.setNome("nome do funcionario novo");
		novo.setEmail("email_2.mock@gmail.com");
		novo.setCpf("123.345.567-00");
		novo.setStatusCadastro(false);

		assertTrue(service.validate(novo));
	}

	@Test(expected = NegocioException.class)
	public void validateFalse() throws NegocioException {
		Colaborador novo = new Colaborador();
		novo.setNome("nome do funcionario novo");
		novo.setEmail("email.mock@gmail.com"); // email repetido
		novo.setCpf("123.345.567-00");
		novo.setStatusCadastro(false);

		service.validate(novo);
	}

	@Test(expected = NegocioException.class)
	public void validateFalse2() throws NegocioException {
		Colaborador novo = new Colaborador();
		novo.setNome("nome do funcionario novo");
		novo.setEmail("email.mock@gmail.com");
		novo.setCpf("001.002.003-55");// cpf repetido
		novo.setStatusCadastro(false);

		service.validate(novo);
	}

	@Test(expected = NegocioException.class)
	public void validateFalse3() throws NegocioException {
		Colaborador novo = new Colaborador();
		novo.setNome("nome do funcionario novo");
		novo.setEmail("email.mock@gmail.com");
		novo.setCpf("001.002.003-55");
		// novo.setStatusCadastro(false); sem status do cadastro

		service.validate(novo);
	}

	@Test(expected = NegocioException.class)
	public void validateFalse4() throws NegocioException {
		Colaborador novo = new Colaborador();
		novo.setNome("nome do funcionario novo");
		novo.setEmail("email.mock@gmail.com");
		novo.setCpf("001.002.003-55");
		Vinculo v = new Vinculo();
		v.setMatricula("123");
		v.setStatusVinculo(true);

		List<Vinculo> lvinculo = new ArrayList<Vinculo>();
		lvinculo.add(v);// 1
		lvinculo.add(v);// 2
		novo.setListVinculo(lvinculo);// 2 vinculos ativo no funcionário
		novo.setStatusCadastro(false);

		service.validate(novo);
		verify(repository).findByCPF("001.002.003-55");
		verify(repository).findByEmail("email.mock@gmail.com");
	}

}
