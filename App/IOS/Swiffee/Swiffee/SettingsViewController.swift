//
//  SettingsViewController.swift
//  Swiffee
//
//  Created by Laksh Bhambhani on 5/6/19.
//  Copyright © 2019 Laksh Bhambhani. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController {

    let textField = UITextField()
    let label = UILabel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.addSubview(textField)
        self.view.addSubview(label)
        
        textField.text = "192.168.0.36"
        textField.textColor = UIColor.gray
        textField.translatesAutoresizingMaskIntoConstraints = false
        textField.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        textField.leftAnchor.constraint(equalTo: label.rightAnchor, constant: 80).isActive = true
        textField.topAnchor.constraint(equalTo: view.topAnchor, constant: 16).isActive = true
        textField.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        label.text = "IP Address:"
        label.translatesAutoresizingMaskIntoConstraints = false
        label.rightAnchor.constraint(equalTo: textField.leftAnchor, constant: -80).isActive = true
        label.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 80).isActive = true
        label.topAnchor.constraint(equalTo: view.topAnchor, constant: 16).isActive = true
        label.heightAnchor.constraint(equalToConstant: 20).isActive = true
    }
}
