// Вариант для информационной системы ветеринарной клиники

public class CatForVetClinic {
    private String name;
    private int age;
    private String breed;
    private String vaccinationInfo;
    private String lastVisitInfo;

    
        public static void main(String[] args) {
            CatForVetClinic cat = new CatForVetClinic("Мурзик", 5, "Шотландская вислоухая");
            
            cat.setVaccinationInfo("Прививка от бешенства выполнена");
            cat.setLastVisitInfo("Посещение ветеринара 10.09.2021");
    
            System.out.println("Имя кота: " + cat.getName());
            System.out.println("Возраст кота: " + cat.getAge());
            System.out.println("Порода кота: " + cat.getBreed());
            System.out.println("Информация о вакцинации: " + cat.getVaccinationInfo());
            System.out.println("Информация о последнем посещении ветеринара: " + cat.getLastVisitInfo());
            System.out.println("Состояние здоровья кота: " + cat.getHealthStatus());
        }
    

    public CatForVetClinic(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setVaccinationInfo(String vaccinationInfo) {
        this.vaccinationInfo = vaccinationInfo;
    }

    public void setLastVisitInfo(String lastVisitInfo) {
        this.lastVisitInfo = lastVisitInfo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getVaccinationInfo() {
        return vaccinationInfo;
    }

    public String getLastVisitInfo() {
        return lastVisitInfo;
    }

    public void scheduleVetAppointment() {
        // Логика записи на прием к ветеринару
    }

    public void updateVaccinationInfo(String info) {
        this.vaccinationInfo = info;
    }

    public String getHealthStatus() {
        // Логика получения информации о состоянии здоровья кота
        return "Здоров";
    }
}
