package nl.quin.complaintservicesystem.controller;

        import nl.quin.complaintservicesystem.model.Employee;
        import nl.quin.complaintservicesystem.service.EmployeeService;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

        import java.net.URI;
        import java.util.Map;

/**
 * CustomerController
 * Implements endpoints for customer resource
 *
 * GET /customers
 * POST /customers
 * GET /customers/{id}
 * PUT /customers/{id}
 * PATCH /customers/{id}
 * DELETE /customers/{id}
 *
 * GET /customers/{id}/complaints => return complaints with id
 * POST /customers/{id}/complaints => body { complaints_id:{id} }
 * DELETE /customers/{id}/complaints/{complaints_id}
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchEmployees(@RequestParam(name = "name", defaultValue = "") String name) {
        return ResponseEntity.ok().body(employeeService.getEmployees(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        long newId = employeeService.createEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployeePartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        employeeService.partialUpdateEmployee(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}