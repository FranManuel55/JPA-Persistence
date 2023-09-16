package com.utn.PersistenceJPA;

import com.utn.PersistenceJPA.entidades.*;
import com.utn.PersistenceJPA.repocitorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersistenceJpaApplication {

	@Autowired
	ClienteRepocitory clienteRepocitory;
	@Autowired
	DetallePedidoRepocitory detallePedidoRepocitory;
	@Autowired
	DomicilioRepocitory domicilioRepocitory;
	@Autowired
	FacturaRepocitory facturaRepocitory;
	@Autowired
	PedidoRepocitory pedidoRepocitory;
	@Autowired
	ProductoRepocitory productoRepocitory;
	@Autowired
	RubroRepocitory rubroRepocitory;

	public static void main(String[] args) {

		SpringApplication.run (PersistenceJpaApplication.class, args);
		System.out.println("<--------------Estoy Funcionando------------->");
	}

	@Bean
	CommandLineRunner init(ClienteRepocitory clienteRepo, DomicilioRepocitory domicilioRepo,
						   DetallePedidoRepocitory detalleRepo, FacturaRepocitory facturaRepo,
						   PedidoRepocitory pedidoRepo, ProductoRepocitory productoRepo,
						   RubroRepocitory rubroRepo) {
		return args -> {

//CrearRubro-------------------------------------------------------------
			Rubro rubro1 = Rubro.builder()
					.denominacionR("Comida Italiana")
					.build();

//CrearProducto-----------------------------------------------------------
			Producto producto1 = Producto.builder()
					.precioCompra(500)
					.precioVenta(900)
					.stockActual(5)
					.stockMinimo(2)
					.tiempoEstimadoCocina(20)
					.tipo(Producto.Tipo.Insumo)
					.denominacion("Carne")
					.receta("Coccion en plancha")
					.unidadMedida("kg")
					.build();

			Producto producto2 = Producto.builder()
					.precioCompra(500)
					.precioVenta(900)
					.stockActual(5)
					.stockMinimo(2)
					.tiempoEstimadoCocina(20)
					.tipo(Producto.Tipo.Insumo)
					.denominacion("Carne")
					.receta("Coccion en plancha")
					.unidadMedida("kg")
					.build();

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			rubroRepocitory.save(rubro1);

//CrearCliente------------------------------------------------------
			Cliente cliente1 = Cliente.builder()
					.nombre("Patricia")
					.apellido("Gomez")
					.telefono(261414257)
					.email("PatriG@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Patricia")
					.apellido("Gomez")
					.telefono(261414257)
					.email("PatriG@gmail.com")
					.build();

//CrearDomicilio----------------------------------------------------------
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Av. San Martin")
					.numero(492)
					.localidad("Mendoza, Ciudad")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Av. San Martin")
					.numero(492)
					.localidad("Mendoza, Ciudad")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Av. San Martin")
					.numero(492)
					.localidad("Mendoza, Ciudad")
					.build();

			cliente1.agregarDomicilio(domicilio1);
			cliente2.agregarDomicilio(domicilio2);
			cliente2.agregarDomicilio(domicilio3);

//CrearDetallePedido-----------------------------------------------------
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(120)
					.subtotal(938.15)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(120)
					.subtotal(938.15)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(120)
					.subtotal(938.15)
					.build();

//CrearPedido-----------------------------------------------------
			Pedido pedido1 = Pedido.builder()
					.estado(Pedido.Estado.Entregado)
					.tipoEnvio(Pedido.TipoEnvio.Delivery)
					.total(9000)
					.fecha("22/06")
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(Pedido.Estado.Entregado)
					.tipoEnvio(Pedido.TipoEnvio.Delivery)
					.total(9000)
					.fecha("22/06")
					.build();

//CrearFactura---------------------------------------------------------------
			Factura factura1 = Factura.builder()
					.numero(20)
					.descuento(0.12)
					.formaDePago(Factura.FormaDePago.Tarjeta)
					.total(6000)
					.fecha("17/05")
					.build();

			Factura factura2 = Factura.builder()
					.numero(20)
					.descuento(0.12)
					.formaDePago(Factura.FormaDePago.Tarjeta)
					.total(6000)
					.fecha("17/05")
					.build();

			pedido1.agregardetallePedidos(detallePedido1);
			pedido2.agregardetallePedidos(detallePedido2);
			pedido2.agregardetallePedidos(detallePedido3);

			cliente1.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);

			detallePedido1.setProductos(producto1);
			detallePedido2.setProductos(producto1);
			detallePedido3.setProductos(producto2);

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			clienteRepo.save(cliente1);
			clienteRepo.save(cliente2);
		};
	}
}