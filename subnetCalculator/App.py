import tkinter as tk
from tkinter import ttk
import ipaddress

def generateInfo():
    ip = ipEntry.get()
    subnetMask = subnetEntry.get()
    
    try:
        ip = ipaddress.IPv4Address(ip)
        network = ipaddress.IPv4Network(f"{ip}/{subnetMask}", strict=False)
        maxHost = network.num_addresses - 2  

        subnetInfo.set(
            f"ID di rete: {network.network_address}\n"
            f"Subnet mask/CIDR: {subnetMask}\n"
            f"Numero massimo di host: {maxHost}\n"
            f"Primo indirizzo utile: {network.network_address + 1}\n"
            f"Ultimo indirizzo utile: {network.broadcast_address - 1}\n"
            f"Indirizzo di broadcast: {network.broadcast_address}\n"
        )

    except (ipaddress.AddressValueError, ipaddress.NetmaskValueError):
        subnetInfo.set("Indirizzo IP o subnet mask non validi.")

# Creare la finestra 
root = tk.Tk()
root.title("Calcolatore Subnet")

# Creare etichette e campi di input
ip_label = ttk.Label(root, text="Indirizzo IP:") 
ip_label.pack(padx=10, pady=5) 
ipEntry = ttk.Entry(root) 
ipEntry.pack(padx=10, pady=5)

subnet_label = ttk.Label(root, text="Subnet mask (es. /24 o 255.255.255.0):")
subnet_label.pack(padx=10, pady=5)
subnetEntry = ttk.Entry(root)
subnetEntry.pack(padx=10, pady=5)

# Bottone 
generate_button = ttk.Button(root, text="Genera", command=generateInfo)
generate_button.pack(padx=10, pady=10)

# Etichetta per il report
subnetInfo = tk.StringVar()
subnet_info_label = ttk.Label(root, textvariable=subnetInfo)
subnet_info_label.pack(padx=10, pady=5)

# Esegui la GUI
root.mainloop()
