package APITest;

import APITest.testExtentions.DBInjector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.resful.booker.DB.sql.DBSqlSteps;
import ru.resful.booker.DB.DBConnection;


@Tag("DB")
public class DbcheckTest extends DBInjector {

    private DBSqlSteps DBSQLSteps;
    @BeforeEach
    public void preconditions(){
        DBSQLSteps = new DBSqlSteps(
                DBInjector.getInjector().getInstance(Key.get(DBConnection.class, Names.named("Postgres")))
        );
    }

    @SneakyThrows
    @Test
    public void test() {
        //DBSteps.getById(1).getId();
        DBSQLSteps.getById(1).getName();
    }

}
