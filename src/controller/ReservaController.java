package controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Mesa;
import model.Reserva;
import service.MesaService;
import service.ReservaService;
@Controller
@RequestMapping("/reservaController")
public class ReservaController {
		
		@Autowired
		private ReservaService reservService;
		@Autowired
		private MesaService mesaService;
		
		
		@RequestMapping(value="listar", method = RequestMethod.GET)
		public String list(ModelMap map) {
			List<Reserva> reservas = reservService.listar();
			map.addAttribute("reservas", reservas);
			map.addAttribute("filtro", new Reserva());
			map.addAttribute("selectMesas",selectMesas());
			return "listarReservas";
		  
		}
		@RequestMapping(value ="criar",method = RequestMethod.GET)
		public String create(ModelMap map){
			Reserva reserva = new Reserva();
			map.addAttribute("reserva",reserva);
			map.addAttribute("selectMesas",selectMesas());
			return "cadastroReserva";
		}
		@RequestMapping(value ="salvar",method = RequestMethod.POST)
		public String save(@ModelAttribute("reserva") Reserva reserv){
			
			if(reserv.getId()>0){
				reservService.atualizar(reserv);
			}
			else{
				reservService.inserir(reserv);
			}
			return "redirect:/reservaController/listar";
		}
		public Map<Long, String> selectMesas(){
			List<Mesa> mesas  = mesaService.listar();
			Map<Long, String> mapa = new TreeMap<Long, String>();
			mapa.put(0L, "Selecione");
			for (Mesa mesa : mesas) {
					if(mesa.getIsReserva()&& mesa.getIsAtivo())
							mapa.put(mesa.getId(), mesa.getDescricao());	
			}
			return mapa;
		}
		
		@RequestMapping(method=RequestMethod.GET, value="{id}/atualizar")
		public String update(@PathVariable Long id, ModelMap map){
			Reserva reserv = new Reserva();
			reserv.setId(id);
			reserv = reservService.buscar(reserv);
			map.addAttribute("reserva", reserv);
			return "cadastroReserva";
		}
		@RequestMapping(method =RequestMethod.GET, value="{id}/remover")
		public String remove(@PathVariable Long id, ModelMap map){
			Reserva reserv = new Reserva();
			reserv.setId(id);
			reserv = reservService.buscar(reserv);
			reservService.remover(reserv);
			return "redirect:/reservaController/listar";
		}
		
		@RequestMapping(value="filtrar",method=RequestMethod.GET)
		public String filtrar(@ModelAttribute("filtro")Reserva reserv, ModelMap map){
			map.addAttribute("selectMesas",selectMesas());
			List<Reserva> reservas = reservService.buscarFiltro(reserv);
			map.addAttribute("reservas",reservas);
			map.addAttribute("filtro",reserv);
			return "listarReservas";
		}
		
		@RequestMapping(value="index", method=RequestMethod.GET)
		public String index(){
				return "index";
		}
		


}
