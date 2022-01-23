import java.util.*;
class Main
{
    public static void bookTicket(Passenger p)
    {
        TicketBooker booker = new TicketBooker();
        if(TicketBooker.availableWaitingList == 0)
        {
            System.out.println("No Tickets Available");
            return;
        }
        if((p.seatPreference.equals("L") && TicketBooker.availableLowerSeats> 0 )||
           (p.seatPreference.equals("M") && TicketBooker.availableMiddleSeats > 0) ||
           (p.seatPreference.equals("U") && TicketBooker.availableUpperSeats > 0))
        {
            System.out.println("Your Preferred Seat is Available");
            if(p.seatPreference.equals("L"))
            {
                System.out.println("Lower Seat is Given");
                booker.bookTicket(p,(TicketBooker.lowerSeatPositions.get(0)),"L");
                TicketBooker.lowerSeatPositions.remove(0);
                TicketBooker.availableLowerSeats--;
            }
            else if(p.seatPreference.equals("M"))
            {
                System.out.println("Middle Seat is Given");
                booker.bookTicket(p,(TicketBooker.middleSeatPositions.get(0)),"M");
                TicketBooker.middleSeatPositions.remove(0);
                TicketBooker.availableMiddleSeats--;
            }
            else if(p.seatPreference.equals("U"))
            {
                System.out.println("Upper Seat is Given");
                booker.bookTicket(p,(TicketBooker.upperSeatPositions.get(0)),"U");
                TicketBooker.upperSeatPositions.remove(0);
                TicketBooker.availableUpperSeats--;
            }
        }
        else if(TicketBooker.availableLowerSeats > 0)
        {
            System.out.println("Your Preference is not availble!!! Lower Seat is Given");
            booker.bookTicket(p,(TicketBooker.lowerSeatPositions.get(0)),"L");
            TicketBooker.lowerSeatPositions.remove(0);
            TicketBooker.availableLowerSeats--;
        }
        else if(TicketBooker.availableMiddleSeats > 0)
        {
            System.out.println("Your Preference is not Available!!! Middle Seat is Given");
            booker.bookTicket(p,(TicketBooker.middleSeatPositions.get(0)),"M");
            TicketBooker.middleSeatPositions.remove(0);
            TicketBooker.availableMiddleSeats--;
        }
        else if(TicketBooker.availableUpperSeats > 0)
        {
            System.out.println("Your Preference is not available!!! Upper Seat is Given");
            booker.bookTicket(p,(TicketBooker.upperSeatPositions.get(0)),"U");
            TicketBooker.upperSeatPositions.remove(0);
            TicketBooker.availableUpperSeats--;
        }
        else if(TicketBooker.availableWaitingList > 0)
        {
            System.out.println("Added to Waiting List");
            booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
        }
    }
    //cancel ticket function
    public static void cancelTicket(int id)
    {
        TicketBooker booker = new TicketBooker();
        if(!booker.passengers.containsKey(id))
        {
            System.out.println("Passenger detail Unknown");
        }
        else
        {
            booker.cancelTicket(id);
            System.out.println("Your ticket has been cancelled");
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while(loop)
        {
            System.out.println(" Welcome : ");
            System.out.println(" 1. Book Ticket ");
            System.out.println(" 2. Cancel Ticket ");
            System.out.println(" 3. Available tickets ");
            System.out.println(" 4. Exit ");
            System.out.println(" Enter your choice: ");
            int choice = s.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter Passenger name: ");
                    String name = s.next();
                    System.out.println("Enter Passenger age: ");
                    int age = s.nextInt();
                    System.out.println("Enter Passenger's Seat Preference(L or M or U): ");
                    String seatPreference = s.next();
                    Passenger p = new Passenger(name,age,seatPreference);
                    bookTicket(p);
                }
                break;
                //cancel ticket
                case 2:
                {
                    System.out.println("Enter passenger Id to cancel");
                    int id = s.nextInt();
                    cancelTicket(id);
                }
                break;
                //available tickets print
                case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                //exit
                case 4:
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
    }
}
class Passenger
{
    static int id = 10;
    String name;
    int age;
    String seatPreference;
    int passengerId;
    String alloted;
    int number;
    public Passenger(String name,int age,String seatPreference)
    {
        this.name = name;
        this.age = age;
        this.seatPreference = seatPreference;
        this.passengerId = id++;
        alloted = "";
        number = -1;
    }
}
class TicketBooker
{
    static int availableLowerSeats = 15;
    static int availableMiddleSeats = 9;
    static int availableUpperSeats = 3;
    static int availableWaitingList = 10;

    static Queue<Integer> waitingList = new LinkedList<>();
    static List<Integer> bookedTicketList =  new ArrayList<>();
    static List<Integer> lowerSeatPositions = new ArrayList<>(Arrays.asList(15));
    static List<Integer> middleSeatPositions = new ArrayList<>(Arrays.asList(9));
    static List<Integer> upperSeatPositions = new ArrayList<>(Arrays.asList(3));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(10));
    //map of passenger ids to passengers
    static Map<Integer, Passenger> passengers = new HashMap<>();
    //book ticket
    public void bookTicket(Passenger p, int SeatInfo,String allotedSeat)
    {
        p.number = SeatInfo;
        p.alloted = allotedSeat;
        passengers.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);        
        System.out.println("Your Ticket Has Booked Successfully");
    }
    //adding to WL
    public void addToWaitingList(Passenger p,int waitingListInfo,String allotedWL)
    {
        p.number = waitingListInfo; 
        p.alloted = allotedWL;
        passengers.put(p.passengerId,p);
        waitingList.add(p.passengerId);
        availableWaitingList--;
        waitingListPositions.remove(0);
        System.out.println("You added to Waiting List!!!");
    }
    //cancel ticket
    public void cancelTicket(int passengerId)
    {
        Passenger p = passengers.get(passengerId);
        passengers.remove(passengerId);
        bookedTicketList.remove(passengerId);
        int positionBooked = p.number;
        System.out.println("Your ticket has been cancelled Successfully");
        if(p.alloted.equals("L")) 
        { 
          availableLowerSeats++;
          lowerSeatPositions.add(positionBooked);
        }
        else if(p.alloted.equals("M"))
        { 
          availableMiddleSeats++;
          middleSeatPositions.add(positionBooked);
        }
        else if(p.alloted.equals("U"))
        { 
          availableUpperSeats++;
          upperSeatPositions.add(positionBooked);
        }
            //check if any WL is there
            if(waitingList.size()>0)
            {
                Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitingList.number;
                waitingListPositions.add(positionWL);
                waitingList.remove(passengerFromWaitingList.passengerId);

                availableWaitingList++;
            }
        }

    //print all available seats
    public void printAvailable()
    {
        System.out.println("Available Lower Seats: "  + availableLowerSeats);
        System.out.println("Available Middle Seats: "  + availableMiddleSeats);
        System.out.println("Available Upper Seats: "  + availableUpperSeats);
        System.out.println("Available Waiting List: " + availableWaitingList);
    }
}