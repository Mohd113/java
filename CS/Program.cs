using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace final
{
    class Program
    {
        // create struct called Friend which has two public variables (name and age)
        struct Friend
        {
            public string studentFullName;
            public int friendAge;
        }
        static void Main(string[] args)
        {
            // quiz
            // call the function once with all three paramters and once without the optional parameter
            PrintMessage(5, 34.65F, "Jerry");
            PrintMessage(6, 53.22F);

            // midterm
            // create two objects of Person class using default constructor and custom constructor
            Person person1 = new Person("Mary", "Green");
            Person person2 = new Person();
            
            // Using property set and get the firstName of person2 object
            person2.FirstName = "Abdullah";
            Console.WriteLine(person2.FirstName);

            // create object of Friend struct and assign variable depending on user input
            Friend friend1;
            Console.WriteLine("Enter your best friend's full name:");
            friend1.studentFullName = Console.ReadLine();
            Console.WriteLine("Enter your best friend's age:");
            friend1.friendAge = Convert.ToInt32(Console.ReadLine());

            // create queue, add three animals, remove one animal
            Queue<string> lineup = new Queue<string>();
            lineup.Enqueue("Dog");
            lineup.Enqueue("Cat");
            lineup.Enqueue("Cow");
            lineup.Dequeue();

            

        }
        
        // method for quiz part
        static void PrintMessage(int x, float y, string message = null)
        {
            if (message != null)
                Console.WriteLine("{0} payments of {1} dollars to be payed to Mr./Mrs. {2}.", x, y, message);
            else
                Console.WriteLine("{0} payments of {1} dollars at being withheld.", x, y);
        }

        // method for midterm part
        static void RetrieveStudent(int location)
        {

        }
    }
}
