package InterfacesAndAbstractionExercise.militaryElite;

import InterfacesAndAbstractionExercise.militaryElite.entities.*;
import InterfacesAndAbstractionExercise.militaryElite.enums.Corps;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.LieutenantGeneral;
import InterfacesAndAbstractionExercise.militaryElite.interfaces.Private;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<Integer, Private> soldiersId = new TreeMap<>();
    private static Map<Integer, LieutenantGeneral> lieutenantGenerals = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");
            String type = data[0];

            createSoldierType(data, type);

            input = scanner.nextLine();
        }
    }

    private static void createSoldierType(String[] data, String type) {
        switch (type) {
            case "Private":
                PrivateImpl aPrivate = new PrivateImpl(Integer.parseInt(data[1]), data[2], data[3],Double.parseDouble(data[4]));
                soldiersId.put(aPrivate.getId(), aPrivate);
                System.out.println(aPrivate);
                break;
            case "LieutenantGeneral":
                PrivateImpl lieutenantGeneralImpl = getLieutenantGeneral(data);
                lieutenantGenerals.put(lieutenantGeneralImpl.getId(), (LieutenantGeneral) lieutenantGeneralImpl);

                lieutenantGenerals.forEach((key, value) -> System.out.println(value));
                break;
            case "Engineer":
                if (isValidCorp(data[5])) {
                    PrivateImpl engineer = getEngineer(data);
                    System.out.println(engineer);
                }
                break;
            case "Commando":
                if (isValidCorp(data[5])) {
                    PrivateImpl commando = getComando(data);
                    System.out.println(commando);
                }
                break;
            case "Spy":
                SpyImpl spy = getSpy(data);
                System.out.println(spy);
                break;
        }
    }

    public static boolean isValidCorp(String corp) {
        return corp.equals("Airforces") || "Marines".equals(corp);
    }
    public static boolean isValidMission(String mission) {
        return mission.equals("finished") || "inProgress".equals(mission);
    }
    private static SpyImpl getSpy(String[] data) {

        return new SpyImpl(Integer.parseInt(data[1]),data[2],data[3],data[4]);
    }
    private static PrivateImpl getComando(String[] data) {

        CommandoImpl commando = new CommandoImpl(Integer.parseInt(data[1]),
                data[2],data[3],
                Double.parseDouble(data[4]),
                Corps.valueOf(data[5]));


            for (int i = 6; i < data.length; i += 2) {
                if (isValidMission(data[i + 1])) {
                    MissionImpl mission = new MissionImpl(data[i], MissionImpl.Status.valueOf(data[i + 1]));
                    commando.addMission(mission);
                }
            }


        return commando;
    }
    private static PrivateImpl getEngineer(String[] data) {

        EngineerImpl engineer = new EngineerImpl(Integer.parseInt(data[1]),data[2],data[3],Double.parseDouble(data[4]),Corps.valueOf(data[5]));

        for (int i = 6; i < data.length; i += 2) {
            RepairImpl repair = new RepairImpl(data[i],Integer.parseInt(data[i + 1]));
            engineer.addRepair(repair);
        }

        return engineer;
    }

    private static PrivateImpl getLieutenantGeneral(String[] data) {
        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(data[1]),data[2],data[3],Double.parseDouble(data[4]));

        List<PrivateImpl> privates = new ArrayList<>();
        for (int i = 5; i < data.length ; i++) {
            privates.add((PrivateImpl) soldiersId.get(Integer.parseInt(data[i])));
        }

        privates =  privates.stream().sorted(Comparator.comparing(PrivateImpl::getId)).collect(Collectors.toList());

        for (int i = privates.size() - 1; i >= 0; i--) {
            lieutenantGeneral.addPrivate(privates.get(i));
        }

        return lieutenantGeneral;
    }
}
