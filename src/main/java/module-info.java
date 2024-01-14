module com.pooespol.p_poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.p_poo to javafx.fxml;
    exports com.pooespol.p_poo;
}
