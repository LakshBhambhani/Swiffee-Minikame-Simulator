//
//  SettingsViewController.swift
//  Swiffee
//
//  Created by Laksh Bhambhani on 5/6/19.
//  Copyright © 2019 Laksh Bhambhani. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController, UITextFieldDelegate {

    let textField = UITextField()
    let label = UILabel()
    let set = UIButton()
    
    var IP:String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.addSubview(textField)
        self.view.addSubview(label)
        self.view.addSubview(set)
        
        textField.text = "192.168.0.36"
        textField.delegate = self
        textField.textColor = UIColor.gray
        textField.translatesAutoresizingMaskIntoConstraints = false
        textField.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        textField.leftAnchor.constraint(equalTo: label.rightAnchor, constant: 80).isActive = true
        textField.topAnchor.constraint(equalTo: view.topAnchor, constant: 16).isActive = true
        textField.heightAnchor.constraint(equalToConstant: 20).isActive = true
        textField.delegate = self
        IP = textField.text!
        
        label.text = "IP Address:"
        label.translatesAutoresizingMaskIntoConstraints = false
        label.rightAnchor.constraint(equalTo: textField.leftAnchor, constant: -80).isActive = true
        label.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 80).isActive = true
        label.topAnchor.constraint(equalTo: view.topAnchor, constant: 16).isActive = true
        label.heightAnchor.constraint(equalToConstant: 20).isActive = true
        
        set.setTitle("Set", for: .normal)
        set.setTitleColor(UIColor.blue, for: .normal)
        set.translatesAutoresizingMaskIntoConstraints = false
        set.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        set.topAnchor.constraint(equalTo: textField.bottomAnchor, constant: 30).isActive = true
        set.rightAnchor.constraint(equalTo: view.rightAnchor).isActive = true
        set.heightAnchor.constraint(equalToConstant: 20).isActive = true
        set.addTarget(self, action: #selector(setAction), for: .touchUpInside)

    }
    
    @objc func setAction(sender: UIButton!) {
        print("Set Clicked")
        IP = textField.text!
        print(IP!)
        print(textField.text!)
    }
    
    
    
}
