package uz.wh.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.wh.collections.ObjectAndMessage;
import uz.wh.db.dao.interfaces.OrderDAO;
import uz.wh.db.dto.documents_dto.OrderWithItemsDTO;
import uz.wh.db.entities.documents.Order;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private OrderDAO orderDAO;
    public OrderController(OrderDAO order) {
        this.orderDAO =order;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<>(orderDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{documentNo}", method = RequestMethod.GET)
    public ResponseEntity<Order> getDocumentNo(@PathVariable String documentNo) {
        return new ResponseEntity<>(orderDAO.getByDocumentNo(documentNo), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Order> getByCustomerName(@PathVariable int customerId) {
        return new ResponseEntity<>(orderDAO.getByCustomerId(customerId), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ObjectAndMessage> saveOrder(@Valid @RequestBody OrderWithItemsDTO order) {
        ObjectAndMessage objectAndMessage = orderDAO.save(order);
        return new ResponseEntity<>(objectAndMessage, HttpStatus.OK);
    }
    @GetMapping(value = "/deleted/{id}")
    public ResponseEntity<ObjectAndMessage> deleteOrder(@PathVariable int id) {
        ObjectAndMessage objectAndMessage = orderDAO.deleteById(id);
        return new ResponseEntity<>(objectAndMessage, HttpStatus.OK);
    }

}
