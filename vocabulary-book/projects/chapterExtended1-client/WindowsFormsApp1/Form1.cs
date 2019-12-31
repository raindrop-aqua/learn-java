using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Thrift.Transport;
using Thrift.Protocol;
using com.example.vocabularybook.chapter_extended1.thrift;

namespace WindowsFormsApp1 {
    public partial class Form1 : Form {
        public Form1() {
            InitializeComponent();
        }

        private void btnTranslate_Click(object sender, EventArgs e) {
            using (THttpClient transport = new THttpClient(new Uri("http://192.168.1.2:8080/api"))) {
                TProtocol protocol = new TBinaryProtocol(transport);
                BookApi.Client client = new BookApi.Client(protocol);

                transport.Open();
                txtResultTranslate.Text = client.search(txtQueryWord.Text);
            }
        }

        private void btnAdd_Click(object sender, EventArgs e) {
            using (THttpClient transport = new THttpClient(new Uri("http://192.168.1.2:8080/api"))) {
                TProtocol protocol = new TBinaryProtocol(transport);
                BookApi.Client client = new BookApi.Client(protocol);

                transport.Open();
                txtResultAdd.Text = client.addword(txtNewWord.Text, txtNewTranslatedWord.Text);
            }

        }

        private void btnDelete_Click(object sender, EventArgs e) {
            using (THttpClient transport = new THttpClient(new Uri("http://192.168.1.2:8080/api"))) {
                TProtocol protocol = new TBinaryProtocol(transport);
                BookApi.Client client = new BookApi.Client(protocol);

                transport.Open();
                txtResultDelete.Text = client.deleteWord(txtDeleteWord.Text);
            }
        }
    }
}
