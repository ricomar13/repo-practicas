package clonesKamino.controllers;

import clonesKamino.domain.CloneTrooper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
//@RequestMapping a nivel de Clase
@RequestMapping("/clones") //Esta anotacion sirve para unificar rutas correspondientes a los endpoint. Reemplaza que en cada anotacion especifique la ruta /clones
public class CloneTrooperRestController {
    /*
    Antes de conectar a BD simularé la obtencion de los datos
    por medio de una lista. Posteriormente lo cambiaré a Mysql
     */
    public List<CloneTrooper> Clones = new ArrayList<>(Arrays.asList(
            new CloneTrooper(7567, "Rex","Captain", "Active", "Anakin Skywalker", "Nicknamed 'Rex', loyal and capable leader"),
            new CloneTrooper(5555, "Fives","ARC Trooper", "Deceased", "Anakin Skywalker", "Known for his independent thinking and bravery"),
            new CloneTrooper(2224, "Cody","Commander", "Active", "Obi-Wan Kenobi", "Often seen with his distinctive orange markings"),
            new CloneTrooper(1409, "Echo","ARC Trooper", "Active", "Anakin Skywalker", "Rescued and integrated with cybernetic enhancements")
    ));

    @GetMapping
    public List<CloneTrooper> getClones(){
        return Clones;
    }

    /*
    Enrutamiento para buscar por atributo los datos del clon
    uso de ciclo para buscar en la lista el atributo
     */

    //no puedo tener la misma ruta base entre endpoints,
    //voy a diferenciarlos haciendo uso de un parametro (ctNumber)
    @GetMapping("/{ctNumber}")
    //public <CloneTrooper> getClon(@PathVariable String ctNumber){
    //para poder retornar mensaje de error o el objeto CloneTrooper uso"?"
    public ResponseEntity<?> getClon(@PathVariable int ctNumber){
        for (CloneTrooper c : Clones){
            if (c.getCtNumber() == ctNumber) {
                return ResponseEntity.ok(c);
            }
        }
        /*
        En este caso retorno null en lugar de exception 404
        por ahora, posteriormente lo cambio
         */
        //return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clon no encontrado");
    }


    /**
     * Metodo POST del tipo CloneTrooper esto vamos a agregar datos del mismo tipo a la lista que generamos
     * @param cloneTrooper
     * @return
     */

    //Con el request body habilitamos que se reciban los datos JSON
    //Asi los valores son transformados y se agregan a la lista

    /*
    Ya que un navegador puede ejecutar solicitudes GET, pero no POST,
    debemos hacer uso de alguna herramienta. En mi caso, POSTMAN
     */
    @PostMapping
    //public CloneTrooper postClon(@RequestBody CloneTrooper cloneTrooper){
    public ResponseEntity<?> postClon(@RequestBody CloneTrooper cloneTrooper){
        Clones.add(cloneTrooper);
        return ResponseEntity.status(HttpStatus.CREATED).body("Clon creado: " + cloneTrooper.getCtNumber());
    }

    /*
    Compara él, id del clon en la lista creada con el id a recibir a traves
    del @RequestBody, si coinciden
    Se pueden cambiar los valores de la lista por nuevas entradas
     */
    @PutMapping
    //public CloneTrooper putClon(@RequestBody CloneTrooper cloneTrooper){
    public ResponseEntity<?> putClon(@RequestBody CloneTrooper cloneTrooper){
        for (CloneTrooper clon : Clones){
            if (clon.getCtNumber() == cloneTrooper.getCtNumber()) {
                clon.setRango(cloneTrooper.getRango());
                clon.setCombatStatus(cloneTrooper.getCombatStatus());
                clon.setAdditionalInfo(cloneTrooper.getAdditionalInfo());

                //return c;
                return ResponseEntity.ok("Los datos del Clon han sido modificados: " + cloneTrooper.getCtNumber());
            }
        }
        //return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Clon a modificar no fue encontrado: " + cloneTrooper.getCtNumber());
    }

    @DeleteMapping("/{ctNumber}")
    //public CloneTrooper deleteClon(@PathVariable String ctNumber){
    public ResponseEntity<?> deleteClon(@PathVariable String ctNumber){
        for (CloneTrooper c : Clones){
            if (Objects.equals(c.getCtNumber(), ctNumber)) {
                Clones.remove(c);

                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Clon eliminado de la central Kamino: " + c.getCtNumber());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clon no encontrado: " + ctNumber);
        //return null;
    }

    @PatchMapping
    //public CloneTrooper patchClon(@RequestBody CloneTrooper cloneTrooper){
    public ResponseEntity<?> patchClon(@RequestBody CloneTrooper cloneTrooper){
        for(CloneTrooper c : Clones){
            if (Objects.equals(c.getCtNumber(), cloneTrooper.getCtNumber())) {
                if (cloneTrooper.getName() != null) {
                    c.setName(cloneTrooper.getName());
                }
                if (cloneTrooper.getRango() != null) {
                    c.setRango(cloneTrooper.getRango());
                }
                if (cloneTrooper.getCombatStatus() != null) {
                    c.setCombatStatus(cloneTrooper.getCombatStatus());
                }
                if (cloneTrooper.getJediCommander() != null) {
                    c.setJediCommander(cloneTrooper.getJediCommander());
                }
                if (cloneTrooper.getAdditionalInfo() != null) {
                    c.setAdditionalInfo(cloneTrooper.getAdditionalInfo());
                }

                return ResponseEntity.ok("Clon modificado exitosamente: " + cloneTrooper.getCtNumber());


            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clon no encontrado: " + cloneTrooper.getCtNumber());
    }




}
