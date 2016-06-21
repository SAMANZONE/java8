import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {


		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> list = Arrays.asList(new Employee(1,"Nimal",22,22),new Employee(1,"Kamal",12,322));

		//============================ forEach
		// 1
		//Old Way

		for(Employee e: list) {
			employeeDao.add(e);
		}

		// New way

		list.forEach(e->employeeDao.add(e));


		//============================filter
		// 2
		//Old Way

		for(Employee e: list) {
			if(e.getEmpName().startsWith("N")){
				employeeDao.add(e);
			}
		}

		// New way

		list.stream()
				.filter((e)->e!=null && e.getEmpName().startsWith("N"))
				.forEach(e->employeeDao.add(e));

		//============================ map
		//3
		//Old Way

		for(Employee e: list) {
			e.doPopulate(e,33);
		    employeeDao.add(e);

		}
		// New way

		list.stream()
				.map((e) -> e.doPopulate(e, 33))
				.forEach(e -> employeeDao.add(e));


		//============================ New Time API
		// previous day  midnight
		//4
		//Old Way

		Calendar calendar = Calendar.getInstance();
		calendar.add(2,Calendar.HOUR_OF_DAY);

		System.out.println("Old Way date-->" +calendar.getTime().toString());


		// New way

		LocalDateTime now = LocalDateTime.now();
		now = now.plus(2, ChronoUnit.HOURS);
		System.out.println("New way date-->" +now.toString());

		//=========================================================
		//5
		//call doPopulate using Annonymous class
		execute(new PopulateInterface() {
			@Override
			public void doPopulate() {
				System.out.println("doPopulate using Anonymous class");
			}

		});

		//call doPopulate using Lambda expression
		execute( () -> System.out.println("doPopulate using Lambda expression") );

		//============================================
		//6
		//Old way:
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Old way thread");
			}
		}).start();

		//New way:
		new Thread(
				() -> System.out.println("New way thread")
		).start();


	}



	public static void execute(PopulateInterface  p) {
		p.doPopulate();
	}

}
