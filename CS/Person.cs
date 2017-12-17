using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace final
{
    class Person
    {
        private string firstName, lastName;

        public Person()
        {

        }

        public Person(string fName, string lName)
        {
            this.firstName = fName;
            this.lastName = lName;
        }

        public void setFirstName(string received = "Mike")
        {
            this.firstName = received;
        }

        public string FirstName
        {
            set { this.firstName = value;  }
            get { return this.firstName; }
        }

        public string LastName
        {
            set { this.lastName = value; }
            get { return this.lastName; }
        }
    }
}
